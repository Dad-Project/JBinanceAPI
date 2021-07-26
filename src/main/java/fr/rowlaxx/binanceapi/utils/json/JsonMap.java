package fr.rowlaxx.binanceapi.utils.json;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(value = { ElementType.FIELD, ElementType.METHOD })
public @interface JsonMap {

	String key();
	
}
