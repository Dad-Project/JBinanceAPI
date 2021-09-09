package fr.rowlaxx.binanceapi.api.http.usdm;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.core.general.usdm.UsdmExchangeInformation;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public interface UsdMMarketData {

	//Test Connectivity
	@ApiEndpoint(
			endpoint = "/fapi/v1/ping",
			baseEndpoint = "https://fapi.binance.com",
			needSignature = true
			)
	public void ping();

	//Check Server time
	@ApiEndpoint(
			endpoint = "/fapi/v1/time",
			baseEndpoint = "https://fapi.binance.com",
			needSignature = true
			)
	@JsonValue(nameInJson = "serverTime")
	public long getServerTime();

	//Exchange Information
	@ApiEndpoint(
			endpoint = "/fapi/v1/exchangeInfo",
			baseEndpoint = "https://fapi.binance.com",
			needSignature = true
			)
	public UsdmExchangeInformation getExchangeInformation();

}
