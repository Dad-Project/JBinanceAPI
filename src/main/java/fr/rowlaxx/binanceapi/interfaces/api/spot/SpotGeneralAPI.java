package fr.rowlaxx.binanceapi.interfaces.api.spot;

import java.util.Collection;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.core.general.spot.SpotExchangeInformation;

public interface SpotGeneralAPI {
	
	@ApiEndpoint(
			endpoint = "/api/v3/ping", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {},
			mandatory = {}
	)
	public void testConnectivity();

	@ApiEndpoint(
			endpoint = "/api/v3/time", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {},
			mandatory = {}
	)
	public long checkServerTime();
	
	@ApiEndpoint(
			endpoint = "/api/v3/exchangeInfo", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {},
			mandatory = {}
	)
	public SpotExchangeInformation getExchangeInformation();
	
	@ApiEndpoint(
			endpoint = "/api/v3/exchangeInfo", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public SpotExchangeInformation getExchangeInformation(String symbol);
	
	@ApiEndpoint(
			endpoint = "/api/v3/exchangeInfo", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbols},
			mandatory = {true}
	)
	public SpotExchangeInformation getExchangeInformation(String... symbols);
	
	@ApiEndpoint(
			endpoint = "/api/v3/exchangeInfo", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbols},
			mandatory = {true}
	)
	public SpotExchangeInformation getExchangeInformation(Collection<String> symbols);
	
}
