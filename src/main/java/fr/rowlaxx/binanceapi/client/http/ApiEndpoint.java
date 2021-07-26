package fr.rowlaxx.binanceapi.client.http;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface ApiEndpoint {

	public String endpoint();
	public String baseEndpoint() default BinanceHttpClient.SPOT_BASE_ENDPOINT;
	public BinanceHttpRequest.Method method() default BinanceHttpRequest.Method.GET;
	public boolean needSignature() default false;
	public Parameters[] parameters() default {};
	public boolean[] mandatory() default {};
	
}
