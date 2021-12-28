package fr.rowlaxx.binanceapi.client.http;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

import fr.rowlaxx.binanceapi.exceptions.BinanceAutoHttpRequestException;
import fr.rowlaxx.utils.generic.ReflectionUtils;

public abstract class BinanceAutoHttpRequest implements Cloneable {

	//Methodes
	final Map<Parameters, Object> getParametersValue() {
		final HashMap<Parameters, Object> map = new HashMap<>();
		
		Parameters parameter;
		ParameterValue parameterValue;
		
		for (Field field : ReflectionUtils.getAllFields(getClass()) ) {
			if (Modifier.isStatic(field.getModifiers()))
				continue;
			if (field.isAnnotationPresent(DontSend.class))
				continue;
			
			if ( (parameterValue = field.getAnnotation(ParameterValue.class)) != null )
				parameter = parameterValue.parameter();
			else
				parameter = Enum.valueOf(Parameters.class, field.getName());

			try {
				field.setAccessible(true);
				map.put(parameter, field.get(this));
			} catch (IllegalAccessException e) {
				throw new BinanceAutoHttpRequestException(e.getMessage());
			}
		}
		
		return map;
	}
	
}
