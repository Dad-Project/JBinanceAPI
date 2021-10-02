package fr.rowlaxx.binanceapi.interfaces.api.spot;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.market.BasicCandlestick;
import fr.rowlaxx.binanceapi.core.market.FinalOrderBook;
import fr.rowlaxx.binanceapi.core.market.Intervals;
import fr.rowlaxx.binanceapi.core.market.SymbolOrderBookTicker;
import fr.rowlaxx.binanceapi.core.market.SymbolPriceTicker;
import fr.rowlaxx.binanceapi.core.market.spot.CurrentAveragePrice;
import fr.rowlaxx.binanceapi.core.market.spot.SpotCompressedTrade;
import fr.rowlaxx.binanceapi.core.market.spot.SpotTickerPriceChangeStatistics24hr;
import fr.rowlaxx.binanceapi.core.market.spot.SpotTrade;
import fr.rowlaxx.jsavon.annotations.MapKey;

public interface SpotMarketDataAPI {

	@ApiEndpoint (
			endpoint = "/api/v3/depth",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit},
			mandatory = {true, false}
	)
	public FinalOrderBook getOrderBook(String symbol, Integer limit);
	
	@ApiEndpoint (
			endpoint = "/api/v3/trades",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit},
			mandatory = {true, false}
	)
	public List<SpotTrade> getRecentTradesList(String symbol, Integer limit);

	@ApiEndpoint (
			endpoint = "/api/v3/historicalTrades",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit, Parameters.fromId},
			mandatory = {true, false, false}
	)
	public List<SpotTrade> getOldTradeList(String symbol, Integer limit, Long fromId);

	@ApiEndpoint (
			endpoint = "/api/v3/aggTrades",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.fromId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<SpotCompressedTrade> getCompressedTradesList(String symbol, Long fromId, Long startTime, Long endTime, Integer limit);

	default List<SpotCompressedTrade> getCompressedTradesList(String symbol, Long fromId, Integer limit) {
		return getCompressedTradesList(symbol, fromId, null, null, limit);
	}
	
	default List<SpotCompressedTrade> getCompressedTradesList(String symbol, Long startTime, Long endTime, Integer limit){
		return getCompressedTradesList(symbol, null, startTime, endTime, limit);
	}
	
	@ApiEndpoint (
			endpoint = "/api/v3/klines",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<BasicCandlestick> getCandlesticks(String symbol, Intervals interval, Long startTime, Long endTime, Integer limit);

	default List<BasicCandlestick> getCandlesticks(String symbol, Intervals interval, Integer limit){
		return getCandlesticks(symbol, interval, null, null, limit);
	}
	
	default List<BasicCandlestick> getCandlesticks(String symbol, Intervals interval){
		return getCandlesticks(symbol, interval, null, null, null);
	}
	
	@ApiEndpoint (
			endpoint = "/api/v3/avgPrice",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public CurrentAveragePrice getCurrentAveragePrice(String symbol);

	@ApiEndpoint (
			endpoint = "/api/v3/ticker/24hr",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public SpotTickerPriceChangeStatistics24hr get24hrTickerPriceChangeStatistics(String symbol);

	@ApiEndpoint (
			endpoint = "/api/v3/ticker/24hr",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, SpotTickerPriceChangeStatistics24hr> get24hrTickersPriceChangeStatistics();	
	
	@ApiEndpoint (
			endpoint = "/api/v3/ticker/price",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public SymbolPriceTicker getSymbolPriceTicker(String symbol);

	@ApiEndpoint (
			endpoint = "/api/v3/ticker/price",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, SymbolPriceTicker> getSymbolPriceTickers();
	
	@ApiEndpoint (
			endpoint = "/api/v3/ticker/bookTicker",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public SymbolOrderBookTicker getSymbolOrderBookTicker(String symbol);
	
	@ApiEndpoint (
			endpoint = "/api/v3/ticker/bookTicker",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, SymbolOrderBookTicker> getSymbolOrderBookTickers();
}