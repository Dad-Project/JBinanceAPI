package fr.rowlaxx.binanceapi.api.http.spot;

import java.util.Collection;
import java.util.List;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.core.api.spot.SpotCandlestick;
import fr.rowlaxx.binanceapi.core.api.spot.SpotExchangeInformation;
import fr.rowlaxx.binanceapi.core.market.Intervals;
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
				needSignature = false,
				parameters = Parameters.symbol,
				mandatory = false
		)
		public SpotExchangeInformation getExchangeInformation(String symbol);
		
		@ApiEndpoint(
				endpoint = "/api/v3/exchangeInfo",
				needSignature = false,
				parameters = Parameters.symbols,
				mandatory = false
		)
		public SpotExchangeInformation getExchangeInformation(String... symbol);
	
		@ApiEndpoint(
				endpoint = "/api/v3/exchangeInfo",
				needSignature = false,
				parameters = Parameters.symbols,
				mandatory = false
		)
		public SpotExchangeInformation getExchangeInformation(Collection<String> symbol);
		
		@ApiEndpoint(
				endpoint = "/api/v3/exchangeInfo",
				needSignature = false
		)
		public SpotExchangeInformation getExchangeInformation();
		
		//Order Book
		@ApiEndpoint(
				endpoint = "/api/v3/depth",
				needSignature = false,
				parameters = {Parameters.symbol, Parameters.limit},
				mandatory = {true, false}
		)
		default void getOrderbook(String symbol, Integer limit) {
			if (limit != null)
				if (limit <= 0 || limit > 5000)
					throw new IllegalArgumentException("limit must be between 1 and 5000. limit=" + limit);
		}
		
		//Candlestick
		@ApiEndpoint(
				endpoint = "/api/v3/klines",
				needSignature = false,
				parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
				mandatory = {true, false, false, false, false}
		)
		public List<SpotCandlestick> getCandlesticks(String symbol, Intervals interval, Long startTime, Long endTime, Integer limit);
}
