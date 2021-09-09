package fr.rowlaxx.binanceapi.client;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.jsavon.utils.ConvertUtils;

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
		final Object response = client.getHttpClient().execute(endpoint, args);

		if (method.getReturnType() == void.class)
			return null;

		return ConvertUtils.convert(response, method.getReturnType());
	}
}