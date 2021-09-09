package fr.rowlaxx.binanceapi.client.http;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface ApiEndpoint {

	//TODO Prendre en compte les endpoints mirroir lors des lags
	public static final String SPOT_BASE_ENDPOINT = "https://api.binance.com";
	public static final String FUTURE_USD_BASE_ENDPOINT = "https://fapi.binance.com";
	public static final String FUTURE_COIN_BASE_ENDPOINT = "https://dapi.binance.com";
	public static final String VANILLA_BASE_ENDPOINT = "https://vapi.binance.com";
	
	public String endpoint();
	public String baseEndpoint();
	public BinanceHttpRequest.Method method();
	public boolean needSignature();
	public Parameters[] parameters();
	public boolean[] mandatory();
	
}
