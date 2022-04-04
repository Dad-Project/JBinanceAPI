package fr.rowlaxx.binanceapi.api.spot;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.BasicCandlestick;
import fr.rowlaxx.binanceapi.core.CompressedTrade;
import fr.rowlaxx.binanceapi.core.OrderBook;
import fr.rowlaxx.binanceapi.core.Intervals;
import fr.rowlaxx.binanceapi.core.BookTicker;
import fr.rowlaxx.binanceapi.core.SymbolPriceTicker;
import fr.rowlaxx.binanceapi.core.spot.marketdata.CurrentAveragePrice;
import fr.rowlaxx.binanceapi.core.spot.marketdata.SpotExchangeInformation;
import fr.rowlaxx.binanceapi.core.spot.marketdata.SpotTickerStatistics;
import fr.rowlaxx.binanceapi.core.spot.marketdata.SpotTrade;
import fr.rowlaxx.convertutils.MapKey;

/**
 * @version 2022-03-19
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#market-data-endpoints
 */
public interface SpotMarketDataAPI extends Api.Https, Api.Spot {

	//Test Connectivity
	@ApiEndpoint(
			endpoint = "/api/v3/ping", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {},
			mandatory = {}
	)
	public void ping();

	//Check Server Time
	@ApiEndpoint(
			endpoint = "/api/v3/time", 
			baseEndpoint = BaseEndpoints.SPOT, 
			method = Method.GET, 
			needSignature = false, 
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "/serverTime")
	public long getServerTime();
	
	//Exchange Information
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
	
	//Order Book
	@ApiEndpoint (
			endpoint = "/api/v3/depth",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit},
			mandatory = {true, false}
	)
	public OrderBook getOrderBook(String symbol, Integer limit);
	
	//Recent Trades List
	@ApiEndpoint (
			endpoint = "/api/v3/trades",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit},
			mandatory = {true, false}
	)
	public List<SpotTrade> getRecentTrades(String symbol, Integer limit);

	//Old Trade Lookup (MARKET_DATA)
	@ApiEndpoint (
			endpoint = "/api/v3/historicalTrades",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit, Parameters.fromId},
			mandatory = {true, false, false}
	)
	public List<SpotTrade> getOldTrades(String symbol, Integer limit, Long fromId);

	//Compressed/Aggregate Trades List
	@ApiEndpoint (
			endpoint = "/api/v3/aggTrades",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.fromId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<CompressedTrade> getCompressedTrades(String symbol, Long fromId, Long startTime, Long endTime, Integer limit);

	default List<CompressedTrade> getCompressedTrades(String symbol, Long fromId, Integer limit) {
		return getCompressedTrades(symbol, fromId, null, null, limit);
	}
	
	default List<CompressedTrade> getCompressedTrades(String symbol, Long startTime, Long endTime, Integer limit){
		return getCompressedTrades(symbol, null, startTime, endTime, limit);
	}
	
	//Kline/Candlestick Data
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
	
	//Current Average Price
	@ApiEndpoint (
			endpoint = "/api/v3/avgPrice",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public CurrentAveragePrice getCurrentAveragePrice(String symbol);

	//24hr Ticker Price Change Statistics
	@ApiEndpoint (
			endpoint = "/api/v3/ticker/24hr",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public SpotTickerStatistics get24hrStatistics(String symbol);

	//Symbol Price Ticker
	@ApiEndpoint (
			endpoint = "/api/v3/ticker/24hr",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, SpotTickerStatistics> get24hrStatistics();		
	
	//Symbol Price Ticker
	@ApiEndpoint (
			endpoint = "/api/v3/ticker/price",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public SymbolPriceTicker getPriceTicker(String symbol);

	@ApiEndpoint (
			endpoint = "/api/v3/ticker/price",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, SymbolPriceTicker> getPriceTickers();
	
	//Symbol Order Book Ticker
	@ApiEndpoint (
			endpoint = "/api/v3/ticker/bookTicker",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public BookTicker getOrderBookTicker(String symbol);
	
	@ApiEndpoint (
			endpoint = "/api/v3/ticker/bookTicker",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, BookTicker> getOrderBookTickers();
}