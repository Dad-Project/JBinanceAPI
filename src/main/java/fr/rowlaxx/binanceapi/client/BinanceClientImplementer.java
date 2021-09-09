package fr.rowlaxx.binanceapi.client;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.exceptions.BinanceClientImplementerException;
import fr.rowlaxx.binanceapi.utils.ConvertUtils;
import fr.rowlaxx.binanceapi.utils.ReflectionUtils;
import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonMap;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;
import fr.rowlaxx.binanceapi.utils.json.JsonValueArray;

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
				if (method.isDefault()) {
					final Object returned = MethodHandles.lookup()
							.findSpecial(
									clazz, 
									method.getName(), 
									MethodType.methodType(method.getReturnType(), method.getParameterTypes()),
									clazz)
							.bindTo(proxy)
							.invokeWithArguments(args);
					if (returned != null)
						return returned;
				}
				
				//Il s'agit d'une requete http
				if (method.isAnnotationPresent(ApiEndpoint.class)) {
					final ApiEndpoint endpoint = method.getAnnotation(ApiEndpoint.class);
					final Object response = client.getHttpClient().execute(endpoint, args);
					if (method.getReturnType() == void.class)
						return null;

					Type[] types = null;
					try {
						types = ((ParameterizedType) method.getGenericReturnType()).getActualTypeArguments();
					}catch(ClassCastException e) {
						types = null;
					}
					
					return convert(method.getReturnType(), types, method, response);
				}
				//TODO Prendre en compte le weksocket
				else if (method.isDefault())
					return null;
				throw new UnsupportedOperationException("The method " + method + " do not have been implemented yet.");				
			}
		});
	}

	/**
	 * Convertir un type d'objet vers un autre type d'objet
	 * @param destination la classe de destination
	 * @param genericTypes les paramètres génériques de la classe de destination
	 * @param annotatedElement les annotions de l'objet à convertir
	 * @param object l'objet à convertir
	 * @return l'objet dans la classe destination
	 */
	public static final Object convert(Class<?> destination, Type[] genericTypes, AnnotatedElement annotatedElement, Object object) {
		if (destination == object.getClass())
			return object;
		
		//Fast Get
		if (annotatedElement instanceof Method) {
			if (object instanceof JSONObject && annotatedElement.isAnnotationPresent(JsonValue.class))
				return fastGetJsonObject(destination, genericTypes, (Method) annotatedElement,(JSONObject) object);
			else if (object instanceof JSONArray && annotatedElement.isAnnotationPresent(JsonValueArray.class))
				return fastGetJsonArray(destination, genericTypes, (Method) annotatedElement, (JSONArray) object);
		}
		
		//Les types disponibles
		if (destination.isEnum()) {
			if (object.toString().isEmpty())
				return null;
			for (Object obj : destination.getEnumConstants())
				if (obj.toString().equals( object.toString() ))
					return obj;
			throw new BinanceClientImplementerException("Cannot find the enum constant " + object.toString() + " in the class " + destination);
		}
		else if (ReflectionUtils.isPrimitiveOrWraper(destination)) {
			try{
				return destination.cast(object);
			}catch(ClassCastException e) {
				return ReflectionUtils.castTo(destination, object.toString());
			}
		}
		else if (destination == String.class) {
			if (object instanceof Number)
				return ConvertUtils.convertToString((Number) object);
			return object.toString();
		}
		else if (Map.class == destination) {
			if ( !(object instanceof JSONArray) )
				throw new BinanceClientImplementerException("Cannot convert a non JSONArray object to a map.");
			return getMap(genericTypes, annotatedElement, (JSONArray)object );
		}
		else if (List.class == destination) {
			if ( !(object instanceof JSONArray) )
				throw new BinanceClientImplementerException("Cannot convert a non JSONArray object to a list.");
			return getList(genericTypes, annotatedElement, (JSONArray)object);
		}
		else if (Set.class.isAssignableFrom(destination)) {
			if ( !(object instanceof JSONArray) )
				throw new BinanceClientImplementerException("Cannot convert a non JSONArray object to a set.");
			return getSet(genericTypes, annotatedElement, (JSONArray)object);
		}
		else if (BinanceResponseJSON.class.isAssignableFrom(destination)) {
			try {
				final Constructor<?> constructor = destination.getConstructor(object.getClass());
				return constructor.newInstance(object);
			} catch (NoSuchMethodException e) {
				if (object instanceof JSONArray) {
					final JSONArray array = (JSONArray)object;
					if ( array.length() == 1)
						return convert(destination, genericTypes, annotatedElement, array.get(0));
				}
				throw new BinanceClientImplementerException("The class " + destination + " do not have a constructor that only accepts the type " + object.getClass());
			} catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
				throw new BinanceClientImplementerException("Error while instanciating. " + e);
			}
		}
		
		
		throw new BinanceClientImplementerException("The class " + destination + " is not supported.");
	}

	//Convert
	@SuppressWarnings("unchecked")
	private static final <K,V> Map<K,V> getMap(final Type[] genericTypes, final AnnotatedElement annotatedElement, final JSONArray array) {
		Objects.requireNonNull(genericTypes, "genericTypes may not be null.");
		Objects.requireNonNull(array, "array may not be null.");
		Objects.requireNonNull(annotatedElement, "annotedElement may not be null.");
		if (!annotatedElement.isAnnotationPresent(JsonMap.class))
			throw new BinanceClientImplementerException("Missing JsonMap annotation.");
		if (genericTypes.length != 2)
			throw new BinanceClientImplementerException("genericTypes must have a length of 2.");

		final Class<K> keyClass = (Class<K>)genericTypes[0];
		final Class<V> valueClass = (Class<V>)genericTypes[1];
		final HashMap<K, V> map = new HashMap<>();
		final String jsonKey = annotatedElement.getAnnotation(JsonMap.class).key();

		K key;
		V value;
		JSONObject json;
		for (int i = 0 ; i < array.length() ; i++) {
			json = array.getJSONObject(i);
			key = (K) convert(keyClass, null, null, json.get(jsonKey));
			value = (V) convert(valueClass, null, null, json);
			map.put(key, value);
		}

		return Collections.unmodifiableMap(map);
	}
	
	@SuppressWarnings("unchecked")
	private static final <T> List<T> getList(Type[] genericTypes, AnnotatedElement annotatedElement, JSONArray array) {
		Objects.requireNonNull(genericTypes, "genericTypes may not be null.");
		Objects.requireNonNull(array, "array may not be null.");
		Objects.requireNonNull(annotatedElement, "annotedElement may not be null.");
		if (genericTypes.length != 1)
			throw new BinanceClientImplementerException("genericTypes must have a length of 1.");
		
		final Class<T> type = (Class<T>)genericTypes[0];
		final ArrayList<T> list = new ArrayList<>();
		
		Object object;
		for (int i = 0 ; i < array.length() ; i++) {
			object = array.get(i);
			list.add( (T) convert(type, null, null, object) );
		}
		
		return Collections.unmodifiableList(list);
	}
	
	@SuppressWarnings("unchecked")
	private static final <T> Set<T> getSet(Type[] genericTypes, AnnotatedElement annotatedElement, JSONArray array) {
		Objects.requireNonNull(genericTypes, "genericTypes may not be null.");
		Objects.requireNonNull(array, "array may not be null.");
		Objects.requireNonNull(annotatedElement, "annotedElement may not be null.");
		if (genericTypes.length != 1)
			throw new BinanceClientImplementerException("genericTypes must have a length of 1.");
		
		final Class<T> type = (Class<T>)genericTypes[0];
		final HashSet<T> set = new HashSet<T>();
		
		Object object;
		for (int i = 0 ; i < array.length() ; i++) {
			object = array.get(i);
			set.add( (T) convert(type, null, null, object) );
		}
		
		return Collections.unmodifiableSet(set);
	}

	//Fast getter
	private static final Object fastGetJsonObject(Class<?> destination, Type[] genericTypes, Method method, JSONObject json) {
		if (method.isAnnotationPresent(JsonValueArray.class))
			throw new BinanceClientImplementerException("The annotation " + JsonValueArray.class + " should not be on the method " + method);
		
		final JsonValue jsonValue = method.getAnnotation(JsonValue.class);
		if (!jsonValue.path().isEmpty())
			for (String path : jsonValue.path().split(Matcher.quoteReplacement("/")))
				json = json.getJSONObject(path);
		
		final Object value = json.opt(jsonValue.nameInJson());
		return checkAndConvert(destination, genericTypes, method, value, jsonValue.mandatory());
	}
	
	private static final Object fastGetJsonArray(Class<?> destination, Type[] genericTypes, Method method, JSONArray array) {
		if (method.isAnnotationPresent(JsonValue.class))
			throw new BinanceClientImplementerException("The annotation " + JsonValue.class + " should not be on the method " + method);
		
		final JsonValueArray jsonValueArray = method.getAnnotation(JsonValueArray.class);

		final Object value = array.opt(jsonValueArray.index());
		return checkAndConvert(destination, genericTypes, method, value, jsonValueArray.mandatory());
	}
	
	private static final Object checkAndConvert(Class<?> destination, Type[] genericTypes, Method method, Object value, boolean mandatory) {
		if (value == null)
			if (mandatory)
				throw new BinanceClientImplementerException("The return is mandatory and cannot be found in the response JSON.");
			else
				return null;
		return convert(destination, genericTypes, method, value);
	}
}