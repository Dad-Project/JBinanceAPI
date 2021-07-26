package fr.rowlaxx.binanceapi.utils.json;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.client.BinanceClientImplementer;
import fr.rowlaxx.binanceapi.utils.ReflectionUtils;

public class BinanceResponseJSON implements Serializable {
	private static final long serialVersionUID = 3826392270549360661L;
	
	//Variables
	@ExcludeAll
	private final Object response;

	//Constructeurs
	public BinanceResponseJSON(JSONObject response) {
		this((Object)response);
		initAsJsonObject();
	}
	
	public BinanceResponseJSON(JSONArray response) {
		this((Object)response);
		initAsJsonArray();
	}
	
	private BinanceResponseJSON(Object response) {
		this.response = Objects.requireNonNull(response, "response may not be null.");
	}

	//Getters
	@SuppressWarnings("unchecked")
	public final <T> T getRawResponse() {
		return (T) response;
	}
	
	public final JSONObject getRawJsonObjectResponse() {
		return getRawResponse();
	}
	
	public final JSONArray getRawJsonArrayResponse() {
		return getRawResponse();
	}

	//Methodes réecrites
	@Override
	public final String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append(getClass().getSimpleName() );

		final List<String> fields = new ArrayList<>();
		for (Field field : ReflectionUtils.getAllFields(getClass())) {
			if (Modifier.isStatic(field.getModifiers()))
				continue;
			if (field.isAnnotationPresent(ExcludeToString.class))
				continue;
			if (field.isAnnotationPresent(ExcludeAll.class))
				continue;

			try {
				if (!field.canAccess(this)) {
					field.setAccessible(true);
					fields.add( field.getName() + "=" + field.get(this).toString() );
					field.setAccessible(false);
				}
				else {
					fields.add( field.getName() + "=" + field.get(this).toString() );
				}
			}catch(Exception e) {
				throw new BinanceResponseJSONException(e.getMessage());
			}
		}

		if (fields.isEmpty())
			return sb.toString();

		sb.append(" [");
		sb.append(fields.get(0));
		for (int i = 1 ; i < fields.size() ; i++) {
			sb.append(", ");
			sb.append(fields.get(i));
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public final boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (this.getClass() != obj.getClass())
			return false;

		Field field2;
		for (Field field1 : ReflectionUtils.getAllFields(getClass())) {
			if (field1.isAnnotationPresent(ExcludeAll.class))
				continue;
			if (field1.isAnnotationPresent(ExcludeEquals.class))
				continue;
			
			System.out.println(field1.getName());
			
			try {
				field2 = obj.getClass().getDeclaredField( field1.getName() );
				if (!field1.canAccess(this)) {
					try {
						field1.setAccessible(true);
						field2.setAccessible(true);
						if ( !field1.get(this).equals( field2.get(this) ) )
							return false;
					}finally {
						field1.setAccessible(false);
						field2.setAccessible(false);
					}

				}
				else {
					if ( !field1.get(this).equals( field2.get(this) ) )
						return false;
				}
			}catch(Exception e) {
				e.printStackTrace();
				throw new BinanceResponseJSONException("An error has occured  : " + e.getMessage());
			}	
		}
		return true;
	}

	@Override
	public final int hashCode() {
		final int prime = 31;
		int result = 1;
		int temp;
		
		for (Field field : ReflectionUtils.getAllFields(getClass()) ) {
			if (field.isAnnotationPresent(ExcludeAll.class))
				continue;
			if (field.isAnnotationPresent(ExcludeHashCode.class))
				continue;
			
			try {
				temp = field.get(this).hashCode();
				result = prime * result + (temp ^ (temp >>> 32));
			}catch(Exception e) {
				e.printStackTrace();
				throw new BinanceResponseJSONException("An error has occured : " + e.getMessage());
			}
		}
		
		return result;
	}

	//Init
	private final void initAsJsonObject() {
		JsonValue annotation;
		JSONObject json;
		Object value;
		
		for (Field field : ReflectionUtils.getAllFields(getClass()) ) {
			if (field.isAnnotationPresent(JsonValueArray.class))
				throw new BinanceResponseJSONException("The annotation JsonValueArray is not permitted here.");
			if (Modifier.isStatic(field.getModifiers()))
				continue;
			if (!field.isAnnotationPresent(JsonValue.class))
				continue;
			
			annotation = field.getDeclaredAnnotation(JsonValue.class);
			
			json = getRawJsonObjectResponse();
			if (!annotation.path().isEmpty())
				try {
					String[] paths = annotation.path().split(Matcher.quoteReplacement("/"));
					for (String path : paths)
						json = json.getJSONObject(path);
				}catch(JSONException e) {
					throw new BinanceResponseJSONException("Path " + annotation.path() + " is unaccessible.");
				}
			
			value = json.opt( annotation.nameInJson().isEmpty() ? field.getName() : annotation.nameInJson() );
			convertAndSet(annotation.mandatory(), field, value);
		}
	}
	
	private final void initAsJsonArray() {
		JsonValueArray annotation;
		final JSONArray array = getRawJsonArrayResponse();
		
		for (Field field : ReflectionUtils.getAllFields(getClass())) {
			if (field.isAnnotationPresent(JsonValue.class))
				throw new BinanceResponseJSONException("The annotation JsonValue is not permitted here.");
			if (Modifier.isStatic(field.getModifiers()))
				continue;
			if (!field.isAnnotationPresent(JsonValueArray.class))
				continue;
			
			annotation = field.getAnnotation(JsonValueArray.class);
			convertAndSet(annotation.mandatory(), field, array.opt(annotation.index()));
		}
	}
	
	private final void convertAndSet(boolean mandatory, Field field, Object value) {
		if (value == null)
			if (mandatory)
				throw new BinanceResponseJSONException("The field \"" + field.getName() + "\" is mandatory and cannot be found in the response JSON.");
			else
				return;
		
		Type[] types;

		try {
			types = ((ParameterizedType) field.getGenericType()).getActualTypeArguments();
		}catch(ClassCastException e) {
			types = null;//Il ne s'agit pas d'une variable générique.
		}
		
		value = BinanceClientImplementer.convert(  ReflectionUtils.toWrapper(field.getType())  , types, field, value );
		
		//On assigne la valeur
		setValue(field, value);
	}
	
	private final void setValue(Field field, Object value) {
		try {
			if ( !field.canAccess(this) ) {
				field.setAccessible(true);
				field.set(this, value);
				field.setAccessible(false);
			}
			else {
				field.set(this, value);
			}
		} catch (IllegalArgumentException e) {
			throw new BinanceResponseJSONException("The specified object is not aninstance of the class or interface declaring the underlyingfield (or a subclass or implementor thereof),or if an unwrapping conversion fails.");
		} catch (IllegalAccessException e) {
			throw new BinanceResponseJSONException("The field \"" + field.toString() + "\" is either inaccessible or final.");
		}
	}
}
