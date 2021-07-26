package fr.rowlaxx.binanceapi.api.http.blvt;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpClient;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.core.api.blvt.BlvtCandlestick;
import fr.rowlaxx.binanceapi.core.api.blvt.BlvtInfo;
import fr.rowlaxx.binanceapi.enums.Intervals;
import fr.rowlaxx.binanceapi.utils.json.JsonMap;

public interface BlvtMarketDataAPI {

	//Get BLVT Info (MARKET_DATA)
	@ApiEndpoint(
			endpoint = "/sapi/v1/blvt/tokenInfo",
			needSignature = false
	)
	@JsonMap(key = "tokenName")
	public Map<String, BlvtInfo> getBlvtInfos();
	
	@ApiEndpoint(
			endpoint = "/sapi/v1/blvt/tokenInfo",
			needSignature = false,
			parameters = {Parameters.tokenName},
			mandatory = {true}
	)
	public BlvtInfo getBlvtInfo(String tokenName);
	
	
	//Historical BLVT NAV Kline/Candlestick
	@ApiEndpoint(
			endpoint = "/fapi/v1/lvtKlines",
			baseEndpoint = BinanceHttpClient.FUTURE_USD_BASE_ENDPOINT,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	default List<BlvtCandlestick> getCandlesticks(String symbol, Intervals interval, Long startTime, Long endTime, Integer limit) {
		if (limit != null)
			if (limit <= 0 || limit > 1000)
				throw new IllegalArgumentException("limit must be between 1 and 1000. limit=" + limit);
		return null;
	}
	
	default List<BlvtCandlestick> getCandlesticks(String symbol, Intervals interval, Integer limit) {
		return getCandlesticks(symbol, interval, null, null, limit);
	}
	
	default List<BlvtCandlestick> getCandlesticks(String symbol, Intervals interval) {
		return getCandlesticks(symbol, interval, null, null, null);
	}
}
