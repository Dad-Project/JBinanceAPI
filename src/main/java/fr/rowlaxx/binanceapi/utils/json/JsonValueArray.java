package fr.rowlaxx.binanceapi.utils.json;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface JsonValueArray {

	int index();
	boolean mandatory() default true;
	
}
