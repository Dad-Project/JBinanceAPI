package fr.rowlaxx.binanceapi.client.http;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface ApiEndpoint {

	public String endpoint();
	public BaseEndpoints baseEndpoint();
	public String[] customBaseEndpoint() default {};
	public BinanceHttpRequest.Method method();
	public boolean needSignature();
	public Parameters[] parameters();
	public boolean[] mandatory();
	
}
