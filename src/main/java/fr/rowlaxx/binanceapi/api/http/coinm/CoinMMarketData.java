package fr.rowlaxx.binanceapi.api.http.coinm;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public interface CoinMMarketData {
	
	//Test Connectivity
	@ApiEndpoint(
			endpoint = "/dapi/v1/ping",
			baseEndpoint = "https://dapi.binance.com",
			needSignature = true
	)
	public void ping();
	
	//Check Server time
	@ApiEndpoint(
			endpoint = "/dapi/v1/time",
			baseEndpoint = "https://dapi.binance.com",
			needSignature = true
	)
	@JsonValue(nameInJson = "serverTime")
	public long getServerTime();
	
	//Exchange Information
	@ApiEndpoint(
			endpoint = "/dapi/v1/exchangeInfo",
			baseEndpoint = "https://dapi.binance.com",
			needSignature = true
	)
	public void getExchangeInformation();
}
