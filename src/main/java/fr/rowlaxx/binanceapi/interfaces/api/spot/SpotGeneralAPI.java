package fr.rowlaxx.binanceapi.interfaces.api.spot;

import java.util.Collection;
import java.util.Collections;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpClient;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.core.market.Intervals;

public interface SpotGeneralAPI {
	
	@ApiEndpoint(
			endpoint = "/api/v3/ping", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {},
			mandatory = {}
	)
	public undone testConnectivity();

	@ApiEndpoint(
			endpoint = "/api/v3/time", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {},
			mandatory = {}
	)
	public undone checkServerTime();
	
	@ApiEndpoint(
			endpoint = "/api/v3/exchangeInfo", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {},
			mandatory = {}
	)
	public undone getExchangeInformation();
	
	@ApiEndpoint(
			endpoint = "/api/v3/exchangeInfo", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public undone getExchangeInformation(String symbol);
	
	@ApiEndpoint(
			endpoint = "/api/v3/exchangeInfo", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbols},
			mandatory = {true}
	)
	public undone getExchangeInformation(String... symbols);
	
	@ApiEndpoint(
			endpoint = "/api/v3/exchangeInfo", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbols},
			mandatory = {true}
	)
	public undone getExchangeInformation(Collection<String> symbols);
	
}
