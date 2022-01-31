package fr.rowlaxx.binanceapi.api.usdm;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.BasicCandlestick;
import fr.rowlaxx.binanceapi.core.CompressedTrade;
import fr.rowlaxx.binanceapi.core.FinalOrderBook;
import fr.rowlaxx.binanceapi.core.Intervals;
import fr.rowlaxx.binanceapi.core.OrderBookTicker;
import fr.rowlaxx.binanceapi.core.SymbolPriceTicker;
import fr.rowlaxx.binanceapi.core.futures.marketdata.ContractTypes;
import fr.rowlaxx.binanceapi.core.futures.marketdata.FundingRate;
import fr.rowlaxx.binanceapi.core.futures.marketdata.OpenInterest;
import fr.rowlaxx.binanceapi.core.futures.marketdata.Period;
import fr.rowlaxx.binanceapi.core.futures.marketdata.PremiumIndex;
import fr.rowlaxx.binanceapi.core.futures.marketdata.PremiumIndexCandlestick;
import fr.rowlaxx.binanceapi.core.usdm.marketdata.AssetIndex;
import fr.rowlaxx.binanceapi.core.usdm.marketdata.CompositeIndex;
import fr.rowlaxx.binanceapi.core.usdm.marketdata.UsdmExchangeInformation;
import fr.rowlaxx.binanceapi.core.usdm.marketdata.UsdmLongShortAccountRatio;
import fr.rowlaxx.binanceapi.core.usdm.marketdata.UsdmLongShortPositionRatio;
import fr.rowlaxx.binanceapi.core.usdm.marketdata.UsdmOpenInterestStatistics;
import fr.rowlaxx.binanceapi.core.usdm.marketdata.UsdmTakerVolume;
import fr.rowlaxx.binanceapi.core.usdm.marketdata.UsdmTickerStatistics;
import fr.rowlaxx.binanceapi.core.usdm.marketdata.UsdmTrade;
import fr.rowlaxx.jsavon.annotations.MapKey;

/**
 * @version 2022-01-31
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/futures/en/#market-data-endpoints
 */
public interface UsdmMarketDataAPI extends Api.Usdm, Api.Https {

	//Test Connectivity
	@ApiEndpoint (
			endpoint = "/fapi/v1/ping",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	public void ping();

	//Check Server Time
	@ApiEndpoint (
			endpoint = "/fapi/v1/time",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "serverTime")
	public long getServerTime();

	//Exchange Information
	@ApiEndpoint (
			endpoint = "/fapi/v1/exchangeInfo",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	public UsdmExchangeInformation getExchangeInformation();

	//Order Book
	@ApiEndpoint (
			endpoint = "/fapi/v1/depth",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit},
			mandatory = {true, false}
	)
	public FinalOrderBook getOrderBook(String symbol, Integer limit);

	//Recent Trades List
	@ApiEndpoint (
			endpoint = "/fapi/v1/trades",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit},
			mandatory = {true, false}
	)
	public List<UsdmTrade> getRecentTrades(String symbol, Integer limit);

	//Old Trades Lookup (MARKET_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v1/historicalTrades",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit, Parameters.fromId},
			mandatory = {true, false, false}
	)
	public List<UsdmTrade> getOldTrades(String symbol, Integer limit, Long fromId);

	//Compressed/Aggregate Trades List
	@ApiEndpoint (
			endpoint = "/fapi/v1/aggTrades",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.fromId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<CompressedTrade> getCompressedTrades(String symbol, Long fromId, Long startTime, Long endTime, Integer limit);

	default List<CompressedTrade> getCompressedTrades(String symbol, Long fromId, Integer limit){
		return getCompressedTrades(symbol, fromId, null, null, limit);
	}
	
	//Kline/Candlestick Data
	@ApiEndpoint (
			endpoint = "/fapi/v1/klines",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<BasicCandlestick> getCandlesticks(String symbol, Intervals interval, Long startTime, Long endTime, Integer limit);

	default List<BasicCandlestick> getCandlesticks(String symbol, Intervals interval, Integer limit){
		return getCandlesticks(symbol, interval, null, null, limit);
	}
	
	//Continuous Contract Kline/Candlestick Data
	@ApiEndpoint (
			endpoint = "/fapi/v1/continuousKlines",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.contractType, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, true, false, false, false}
	)
	public List<BasicCandlestick> getContinuousContractCandlesticks(String pair, ContractTypes contractType, Intervals interval, Long startTime, Long endTime, Integer limit);

	default List<BasicCandlestick> getContinuousContractCandlesticks(String pair, ContractTypes contractType, Intervals interval, Integer limit){
		return getContinuousContractCandlesticks(pair, contractType, interval, null, null, limit);
	}
	
	//Index Price Kline/Candlestick Data
	@ApiEndpoint (
			endpoint = "/fapi/v1/indexPriceKlines",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<PremiumIndexCandlestick> getIndexCandlesticks(String pair, Intervals interval, Long startTime, Long endTime, Integer limit);

	default List<PremiumIndexCandlestick> getIndexCandlesticks(String pair, Intervals interval, Integer limit){
		return getIndexCandlesticks(pair, interval, null, null, limit);
	}
	
	//Mark Price Kline/Candlestick Data
	@ApiEndpoint (
			endpoint = "/fapi/v1/markPriceKlines",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<PremiumIndexCandlestick> getMarkCandlesticks(String pair, Intervals interval, Long startTime, Long endTime, Integer limit);

	default List<PremiumIndexCandlestick> getMarkCandlesticks(String pair, Intervals interval, Integer limit){
		return getIndexCandlesticks(pair, interval, null, null, limit);
	}
	
	//Mark Price
	@ApiEndpoint (
			endpoint = "/fapi/v1/premiumIndex",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, PremiumIndex> getPremiumIndexes();

	@ApiEndpoint (
			endpoint = "/fapi/v1/premiumIndex",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public PremiumIndex getPremiumIndex(String symbol);

	//Get Funding Rate History
	@ApiEndpoint (
			endpoint = "/fapi/v1/fundingRate",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false}
	)
	public List<FundingRate> getFundingRateHistory(String symbol, Long startTime, Long endTime, Integer limit);

	default List<FundingRate> getFundingRateHistory(String symbol, Integer limit){
		return getFundingRateHistory(symbol, null, null, limit);
	}
	
	//24hr Ticker Price Change Statistics
	@ApiEndpoint (
			endpoint = "/fapi/v1/ticker/24hr",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public UsdmTickerStatistics get24hrStatistics(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/ticker/24hr",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, UsdmTickerStatistics> get24hrStatistics();

	//Symbol Price Ticker
	@ApiEndpoint (
			endpoint = "/fapi/v1/ticker/price",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public SymbolPriceTicker getPriceTicker(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/ticker/price",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, SymbolPriceTicker> getPriceTickers();
	
	//Symbol Order Book Ticker
	@ApiEndpoint (
			endpoint = "/fapi/v1/ticker/bookTicker",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public OrderBookTicker getOrderBookTicker(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/ticker/bookTicker",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, OrderBookTicker> getOrderBookTickers();

	//Open Interest
	@ApiEndpoint (
			endpoint = "/fapi/v1/openInterest",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public OpenInterest getOpenInterest(String symbol);

	//Open Interest Statistics
	@ApiEndpoint (
			endpoint = "/futures/data/openInterestHist",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<UsdmOpenInterestStatistics> getOpenInterestStatistics(String symbol, Period period, Integer limit, Long startTime, Long endTime);

	default List<UsdmOpenInterestStatistics> getOpenInterestStatistics(String symbol, Period period, Integer limit){
		return getOpenInterestStatistics(symbol, period, limit, null, null);
	}
	
	//Top Trader Long/Short Ratio (Accounts)
	@ApiEndpoint (
			endpoint = "/futures/data/topLongShortAccountRatio",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<UsdmLongShortAccountRatio> getTopTraderAccountRatio(String symbol, Period period, Integer limit, Long startTime, Long endTime);
	
	default List<UsdmLongShortAccountRatio> getTopTraderAccountRatio(String symbol, Period period, Integer limit){
		return getTopTraderAccountRatio(symbol, period, limit, null, null);
	}
	
	//Top Trader Long/Short Ratio (Positions)
	@ApiEndpoint (
			endpoint = "/futures/data/topLongShortPositionRatio",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<UsdmLongShortPositionRatio> getTopTraderPositionRatio(String symbol, Period period, Integer limit, Long startTime, Long endTime);
	
	default List<UsdmLongShortPositionRatio> getTopTraderPositionRatio(String symbol, Period period, Integer limit){
		return getTopTraderPositionRatio(symbol, period, limit, null, null);
	}
	
	//Long/Short Ratio
	@ApiEndpoint (
			endpoint = "/futures/data/globalLongShortAccountRatio",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<UsdmLongShortAccountRatio> getGlobalAccountRatio(String symbol, Period period, Integer limit, Long startTime, Long endTime);
	
	default List<UsdmLongShortAccountRatio> getGlobalAccountRatio(String symbol, Period period, Integer limit){
		return getGlobalAccountRatio(symbol, period, limit, null, null);
	}
	
	//Taker Buy/Sell Volume
	@ApiEndpoint (
			endpoint = "/futures/data/takerlongshortRatio",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<UsdmTakerVolume> getTakerBuySellVolume(String symbol, Period period, Integer limit, Long startTime, Long endTime);

	default List<UsdmTakerVolume> getTakerBuySellVolume(String symbol, Period period, Integer limit){
		return getTakerBuySellVolume(symbol, period, limit, null, null);
	}
	
	//Composite Index Symbol Information
	@ApiEndpoint (
			endpoint = "/fapi/v1/indexInfo",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public CompositeIndex getCompositeIndex(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/indexInfo",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, CompositeIndex> getCompositeIndexes();
	
	//Multi-Assets Mode Asset Index
	@ApiEndpoint (
			endpoint = "/fapi/v1/assetIndex",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public AssetIndex getAssetIndex(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/assetIndex",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, AssetIndex> getAssetIndexes();
}
