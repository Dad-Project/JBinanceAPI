package fr.rowlaxx.binanceapi.api;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.client.BinanceClientImpl;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.exceptions.BinanceHttpClientException;
import fr.rowlaxx.jsavon.Jsavon;
import fr.rowlaxx.utils.GenericUtils;

public class ApiImplementer {

	public static final Api implementz(Class<? extends Api> clazz, final BinanceClientImpl client) {
		if (!clazz.isInterface())
			throw new IllegalArgumentException("The provided class is not an interface.");

		final ClassLoader cl = ApiImplementer.class.getClassLoader();
		final Class<?>[] interfaces = new Class[] {clazz};

		return (Api) Proxy.newProxyInstance(cl, interfaces, new InvocationHandler() {

			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {				
				if (method.isDefault())
					return InvocationHandler.invokeDefault(proxy, method, args);

				if (method.isAnnotationPresent(ApiEndpoint.class))
					return invokeEndpoint(client, proxy, method, args);

				throw new UnsupportedOperationException("The method " + method + " do not have been implemented yet.");				
			}
		});
	}

	private static final Object invokeEndpoint(final BinanceClientImpl client, final Object proxy, final Method method, final Object[] args) throws IOException {		
		final ApiEndpoint endpoint = method.getAnnotation(ApiEndpoint.class);
		Object response = client.getHttpClient().execute(endpoint, args);
		
		if (method.getReturnType() == void.class)
			return null;

		final RedirectResponse redirectResponse = method.getAnnotation(RedirectResponse.class);
		if (redirectResponse != null) {
			String path = redirectResponse.path();
			Integer param = null;
			
			if (path.matches("%[A-Z_]*=[0-9]*"))
				param = Integer.valueOf( path.substring(path.indexOf('=')+1), path.lastIndexOf('%') );
			
			if (response instanceof JSONObject) {
				if (param != null)
					if (path.contains("PARAMETER_NO"))
						path = Jsavon.converter.convert(args[param], String.class);
					else
						throw new BinanceHttpClientException("Unknow special path for JSONObject " + path);

				for (String p : path.split("/"))
					if (!p.isBlank())
						response = ((JSONObject)response).get(p);
			}
			else if (response instanceof JSONArray) {
				if (param != null)
					if (path.contains("INDEX"))
						response =  ((JSONArray)response).get(param);
					else
						throw new BinanceHttpClientException("Unknow special path for JSONArray " + path);
			}
		}
		
		final Type destination = GenericUtils.resolve(method.getGenericReturnType(), method.getDeclaringClass());
		return Jsavon.converter.convert(response, destination);
	}
}