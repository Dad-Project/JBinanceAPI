package fr.rowlaxx.binanceapi.interfaces.api.spot;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.market.Intervals;

public interface SpotMarketDataAPI {

	@ApiEndpoint(
			endpoint = "/api/v3/depth", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbol, Parameters.limit},
			mandatory = {true, false}
	)
	public undone getOrderBook(String symbol, Integer limit);
	
	default undone orderBook(String symbol) {
		return orderBook(symbol, null);
	}
	
	@ApiEndpoint(
			endpoint = "/api/v3/trades", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbol, Parameters.limit},
			mandatory = {true, false}
	)
	public undone getRecentTradesList(String symbol, Integer limit);
	
	default undone recentTradesList(String symbol) {
		return recentTradesList(symbol, null);
	}
	
	@ApiEndpoint(
			endpoint = "/api/v3/historicalTrades", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbol, Parameters.limit, Parameters.fromId},
			mandatory = {true, false, false}
	)
	public undone getOldTradeLookup(String symbol, Integer limit, Long fromId);
	
	@ApiEndpoint(
			endpoint = "/api/v3/aggTrades", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbol, Parameters.fromId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public undone getCompressedTradesList(String symbol, Long fromId, Long startTime, Long endTime, Integer limit);
	
	default undone getCompressedTradesList(String symbol, Long fromId, Integer limit) {
		return getCompressedTradesList(symbol, fromId, null, null, limit);
	}
	
	default undone getAggregateTradesList(String symbol, Long fromId, Long startTime, Long endTime, Integer limit) {
		return getCompressedTradesList(symbol, fromId, startTime, endTime, limit);
	}
	
	default undone getAggregateTradesList(String symbol, Long fromId, Integer limit) {
		return getCompressedTradesList(symbol, fromId, limit);
	}
	
	@ApiEndpoint(
			endpoint = "/api/v3/klines", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public undone getKlineData(String symbol, Intervals interval, Long startTime, Long endTime, Integer limit);
	
	default undone getKlineData(String symbol, Intervals interval, Integer limit) {
		return getKlineData(symbol, interval, null, null, limit);
	}
	
	default undone getKlineData(String symbol, Intervals interval) {
		return getKlineData(symbol, interval, null, null, null);
	}
	
	default undone getCandlestickData(String symbol, Intervals interval, Long startTime, Long endTime, Integer limit) {
		return getKlineData(symbol, interval, startTime, endTime, limit);
	}
	
	default undone getCandlestickData(String symbol, Intervals intervals, Integer limit) {
		return getKlineData(symbol, intervals, limit);
	}
	
	default undone getCandlestickData(String symbol, Intervals intervals) {
		return getKlineData(symbol, intervals);
	}
	
	@ApiEndpoint(
			endpoint = "/api/v3/avgPrice", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public undone getCurrentAveragePrice(String symbol);
	
	@ApiEndpoint(
			endpoint = "/api/v3/ticker/24hr", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {},
			mandatory = {}
	)
	public undone get24hrTickersPriceChangeStatistics();
	
	@ApiEndpoint(
			endpoint = "/api/v3/ticker/24hr", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public undone get24hrTickerPriceChangeStatistics(String symbol);
	
	@ApiEndpoint(
			endpoint = "/api/v3/ticker/price", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {},
			mandatory = {}
	)
	public undone getSymbolPriceTickers();
	
	@ApiEndpoint(
			endpoint = "/api/v3/ticker/price", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public undone getSymbolPriceTicker(String symbol);
	
	@ApiEndpoint(
			endpoint = "/api/v3/ticker/bookTicker", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {},
			mandatory = {}
	)
	public undone getSymbolOrderBookTickers();
	
	@ApiEndpoint(
			endpoint = "/api/v3/ticker/bookTicker", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public undone getSymbolOrderBookTicker(String symbol);
	
}
