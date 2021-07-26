package fr.rowlaxx.binanceapi.api.http.spot;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public interface SpotMarketData {

	//Test Connectivity
		@ApiEndpoint(
				endpoint = "/api/v3/ping",
				needSignature = false
		)
		public void ping();
		
		//Check Server time
		@ApiEndpoint(
				endpoint = "/api/v3/time",
				needSignature = false
		)
		@JsonValue(nameInJson = "serverTime")
		public long getServerTime();
		
		//Exchange Information
		@ApiEndpoint(
				endpoint = "/api/v3/exchangeInfo",
				needSignature = false
		)
		public void getExchangeInformation();
	
}
