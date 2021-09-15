package fr.rowlaxx.binanceapi.client;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.exceptions.BinanceHttpClientException;
import fr.rowlaxx.jsavon.convert.ConvertRequest;
import fr.rowlaxx.jsavon.convert.Destination;
import fr.rowlaxx.jsavon.convert.DestinationResolver;

public class BinanceClientImplementer {

	@SuppressWarnings("unchecked")
	static <T> T implementz(Class<T> clazz, final BinanceClient client) {
		if (!clazz.isInterface())
			throw new IllegalArgumentException("The provided class is not an interface.");

		final ClassLoader cl = BinanceClientImplementer.class.getClassLoader();
		final Class<?>[] interfaces = new Class[] {clazz};

		return (T) Proxy.newProxyInstance(cl, interfaces, new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {				
				if (method.isDefault())
					return invokeDefault(clazz, proxy, method, args);

				if (method.isAnnotationPresent(ApiEndpoint.class))
					return invokeEndpoint(client, proxy, method, args);

				throw new UnsupportedOperationException("The method " + method + " do not have been implemented yet.");				
			}
		});
	}

	private static Object invokeDefault(Class<?> clazz, Object proxy, Method method, Object[] args) throws IllegalAccessException, Throwable {
		return MethodHandles.lookup()
				.findSpecial(
						clazz, 
						method.getName(), 
						MethodType.methodType(method.getReturnType(), method.getParameterTypes()),
						clazz)
				.bindTo(proxy)
				.invokeWithArguments(args);
	}

	private static Object invokeEndpoint(BinanceClient client, Object proxy, Method method, Object[] args) throws IOException {
		final ApiEndpoint endpoint = method.getAnnotation(ApiEndpoint.class);
		Object response = client.getHttpClient().execute(endpoint, args);

		if (method.getReturnType() == void.class)
			return null;

		if (method.isAnnotationPresent(RedirectResponse.class)) {
			String path = method.getAnnotation(RedirectResponse.class).path();
			if (response instanceof JSONObject) {
				if (path.matches("%PARAMETER_NO=[0-9]*%")){
					final int no = Integer.valueOf( path.substring(path.indexOf('=')+1, path.lastIndexOf('%')));
					final ConvertRequest<String> request = new ConvertRequest<String>(args[no], Destination.from(String.class));
					path = request.execute();
				}
				for (String p : path.split("/"))
					if (!p.isBlank())
						response = ((JSONObject)response).get(p);
			}
			else if (response instanceof JSONArray) {
				if (path.matches("%INDEX=[0-9]*%")) {
					final int no = Integer.valueOf( path.substring(path.indexOf('=')+1, path.lastIndexOf('%')));
					try{
						response = ((JSONArray) response).get(no);
					}catch(JSONException e) {
						throw new BinanceHttpClientException("Cannot access the object at index " + no + " in the JSONArray : \n" + response);
					}
				}
				else
					throw new UnsupportedOperationException("Cannot handle to redirect \"" + path + "\" for JSONArray.");
			}
		}


		final Destination<?> destination = DestinationResolver.resolve(method);
		final ConvertRequest<?> request = new ConvertRequest<>(response, destination);
		return request.execute();
	}
}