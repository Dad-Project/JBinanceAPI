package fr.rowlaxx.binanceapi.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ReflectionUtils {

	public static final Class<?> toWrapper(Class<?> clazz){
		if (!clazz.isPrimitive())
			return clazz;

		if (clazz == int.class)
			return Integer.class;
		if (clazz == double.class)
			return Double.class;
		if (clazz == byte.class)
			return Byte.class;
		if (clazz == short.class)
			return Short.class;
		if (clazz == long.class)
			return Long.class;
		if (clazz == float.class)
			return Float.class;
		if (clazz == boolean.class)
			return Boolean.class;
		return Void.class;
	}

	public static List<Field> getAllFields(Class<?> type) {
		List<Field> fields = new ArrayList<Field>();
		for (Class<?> c = type; c != null; c = c.getSuperclass())
			fields.addAll(Arrays.asList(c.getDeclaredFields()));
		fields.sort(new Comparator<Field>() {
			@Override
			public int compare(Field o1, Field o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
		return fields;
	}
	
	public static boolean isPrimitiveOrWraper(Class<?> clazz) {
		if (clazz.isPrimitive())
			return true;
		return 
				clazz == Boolean.class || 
				clazz == Void.class || 
				clazz == Byte.class || 
				clazz == Short.class || 
				clazz == Integer.class || 
				clazz == Long.class || 
				clazz == Double.class || 
				clazz == Float.class ||
				clazz == Void.class;
	}

	public static Object castTo(Class<?> destination, String str) {
		destination = ReflectionUtils.toWrapper(destination);
		if (destination == Double.class)
			return Double.valueOf(str);
		if (destination == Float.class)
			return Float.valueOf(str);
		if (destination == Boolean.class)
			return Boolean.valueOf(str);
		if (destination == Byte.class)
			return Byte.valueOf(str);
		if (destination == Short.class)
			return Short.valueOf(str);
		if (destination == Integer.class)
			return Integer.valueOf(str);
		if (destination == Long.class)
			return Long.valueOf(str);
		throw new IllegalArgumentException("Unknow destination.");
	}
	
}
