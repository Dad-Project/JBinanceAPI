package fr.rowlaxx.binanceapi.api.coinm;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.CompressedTrade;
import fr.rowlaxx.binanceapi.core.FinalOrderBook;
import fr.rowlaxx.binanceapi.core.Intervals;
import fr.rowlaxx.binanceapi.core.coinm.marketdata.Basis;
import fr.rowlaxx.binanceapi.core.coinm.marketdata.CoinmCandlestick;
import fr.rowlaxx.binanceapi.core.coinm.marketdata.CoinmExchangeInformation;
import fr.rowlaxx.binanceapi.core.coinm.marketdata.CoinmLongShortAccountRatio;
import fr.rowlaxx.binanceapi.core.coinm.marketdata.CoinmLongShortPositionRatio;
import fr.rowlaxx.binanceapi.core.coinm.marketdata.CoinmOpenInterest;
import fr.rowlaxx.binanceapi.core.coinm.marketdata.CoinmOpenInterestStatistics;
import fr.rowlaxx.binanceapi.core.coinm.marketdata.CoinmOrderBookTicker;
import fr.rowlaxx.binanceapi.core.coinm.marketdata.CoinmSymbolPriceTicker;
import fr.rowlaxx.binanceapi.core.coinm.marketdata.CoinmTakerVolume;
import fr.rowlaxx.binanceapi.core.coinm.marketdata.CoinmTickerStatistics;
import fr.rowlaxx.binanceapi.core.coinm.marketdata.CoinmTrade;
import fr.rowlaxx.binanceapi.core.futures.marketdata.ContractTypes;
import fr.rowlaxx.binanceapi.core.futures.marketdata.FundingRate;
import fr.rowlaxx.binanceapi.core.futures.marketdata.Period;
import fr.rowlaxx.binanceapi.core.futures.marketdata.PremiumIndex;
import fr.rowlaxx.binanceapi.core.futures.marketdata.PremiumIndexCandlestick;
import fr.rowlaxx.convertutils.MapKey;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;

/**
 * @version 2022-01-31
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/delivery/en/#market-data-endpoints
 */
public interface CoinmMarketDataAPI extends Api.Https, Api.Coinm {

	//Test Connectivity
	@ApiEndpoint (
			endpoint = "/dapi/v1/ping",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	public void ping();

	//Check Server time
	@ApiEndpoint (
			endpoint = "/dapi/v1/time",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "serverTime")
	public long getServerTime();

	//Exchange Information
	@ApiEndpoint (
			endpoint = "/dapi/v1/exchangeInfo",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	public CoinmExchangeInformation getExchangeInformation();

	//Order Book
	@ApiEndpoint (
			endpoint = "/dapi/v1/depth",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit},
			mandatory = {true, false}
	)
	public FinalOrderBook getOrderBook(String symbol, Integer limit);

	//Recent Trades List
	@ApiEndpoint (
			endpoint = "/dapi/v1/trades",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit},
			mandatory = {true, false}
	)
	public List<CoinmTrade> getRecentTrades(String symbol, Integer limit);

	//Old Trades Lookup (MARKET_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v1/historicalTrades",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit, Parameters.fromId},
			mandatory = {true, false, false}
	)
	public List<CoinmTrade> getOldTrades(String symbol, Integer limit, Long fromId);

	//Compressed/Aggregate Trades List
	@ApiEndpoint (
			endpoint = "/dapi/v1/aggTrades",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.fromId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<CompressedTrade> getCompressedTrades(String symbol, Long fromId, Long startTime, Long endTime, Integer limit);

	default List<CompressedTrade> getCompressedTrades(String symbol, Long fromId, Integer limit){
		return getCompressedTrades(symbol, fromId, null, null, limit);
	}
	
	//Index Price and Mark Price
	@ApiEndpoint (
			endpoint = "/dapi/v1/premiumIndex",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair},
			mandatory = {true}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, PremiumIndex> getPremiumIndexes(String pair);

	@ApiEndpoint (
			endpoint = "/dapi/v1/premiumIndex",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, PremiumIndex> getPremiumIndexes();
	
	@ApiEndpoint (
			endpoint = "/dapi/v1/premiumIndex",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public PremiumIndex getPremiumIndex(String symbol);

	//Get Funding Rate History of Perpetual Futures
	@ApiEndpoint (
			endpoint = "/dapi/v1/fundingRate",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false}
	)
	public List<FundingRate> getFundingRateHistory(String symbol, Long startTime, Long endTime, Integer limit);

	default List<FundingRate> getFundingRateHistory(String symbol, Integer limit){
		return getFundingRateHistory(symbol, null, null, limit);
	}
	
	//Kline/Candlestick Data
	@ApiEndpoint (
			endpoint = "/dapi/v1/klines",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<CoinmCandlestick> getCandlesticks(String symbol, Intervals interval, Long startTime, Long endTime, Integer limit);

	default List<CoinmCandlestick> getCandlesticks(String symbol, Intervals interval, Integer limit){
		return getCandlesticks(symbol, interval, null, null, limit);
	}
	
	//Continuous Contract Kline/Candlestick Data
	@ApiEndpoint (
			endpoint = "/dapi/v1/continuousKlines",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.contractType, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, true, false, false, false}
	)
	public List<CoinmCandlestick> getContinuousContractCandlesticks(String pair, ContractTypes contractType, Intervals interval, Long startTime, Long endTime, Integer limit);

	default List<CoinmCandlestick> getContinuousContractCandlesticks(String pair, ContractTypes contractType, Intervals interval, Integer limit){
		return getContinuousContractCandlesticks(pair, contractType, interval, null, null, limit);
	}
	
	//Index Price Kline/Candlestick Data
	@ApiEndpoint (
			endpoint = "/dapi/v1/indexPriceKlines",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
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
			endpoint = "/dapi/v1/markPriceKlines",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<PremiumIndexCandlestick> getMarkCandlesticks(String pair, Intervals interval, Long startTime, Long endTime, Integer limit);

	default List<PremiumIndexCandlestick> getMarkCandlesticks(String pair, Intervals interval, Integer limit){
		return getIndexCandlesticks(pair, interval, null, null, limit);
	}
	
	//24hr Ticker Price Change Statistics
	@ApiEndpoint (
			endpoint = "/dapi/v1/ticker/24hr",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair},
			mandatory = {true}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, CoinmTickerStatistics> get24hrStatisticsPair(String pair);

	@ApiEndpoint (
			endpoint = "/dapi/v1/ticker/24hr",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, CoinmTickerStatistics> get24hrStatistics();

	@ApiEndpoint (
			endpoint = "/dapi/v1/ticker/24hr",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public CoinmTickerStatistics get24hrStatisticsSymbol(String symbol);

	//Symbol Price Ticker
	@ApiEndpoint (
			endpoint = "/dapi/v1/ticker/price",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair},
			mandatory = {true}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, CoinmSymbolPriceTicker> getPriceTickers(String pair);

	@ApiEndpoint (
			endpoint = "/dapi/v1/ticker/price",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, CoinmSymbolPriceTicker> getPriceTickers();

	@ApiEndpoint (
			endpoint = "/dapi/v1/ticker/price",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	@RedirectResponse(path = "%INDEX=0%")
	public CoinmSymbolPriceTicker getPriceTicker(String symbol);
	
	//Symbol Order Book Ticker
	@ApiEndpoint (
			endpoint = "/dapi/v1/ticker/bookTicker",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair},
			mandatory = {true}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, CoinmOrderBookTicker> getOrderBookTickers(String pair);

	@ApiEndpoint (
			endpoint = "/dapi/v1/ticker/bookTicker",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, CoinmOrderBookTicker> getOrderBookTickers();

	@ApiEndpoint (
			endpoint = "/dapi/v1/ticker/bookTicker",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	@MapKey(fieldName = "symbol")
	@RedirectResponse(path = "%INDEX=0%")
	public CoinmOrderBookTicker getOrderBookTicker(String symbol);

	//Open Interest
	@ApiEndpoint (
			endpoint = "/dapi/v1/openInterest",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public CoinmOpenInterest getOpenInterest(String symbol);

	//Open Interest Statistics
	@ApiEndpoint (
			endpoint = "/futures/data/openInterestHist",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.contractType, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, true, false, false, false}
	)
	public List<CoinmOpenInterestStatistics> getOpenInterestStatistics(String pair, ContractTypes contractType, Period period, Integer limit, Long startTime, Long endTime);

	default List<CoinmOpenInterestStatistics> getOpenInterestStatistics(String pair, ContractTypes contractType, Period period, Integer limit){
		return getOpenInterestStatistics(pair, contractType, period, limit, null, null);
	}
	
	//Top Trader Long/Short Ratio (Accounts)
	@ApiEndpoint (
			endpoint = "/futures/data/topLongShortAccountRatio",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<CoinmLongShortAccountRatio> getTopTraderAccountRatio(String pair, Period period, Integer limit, Long startTime, Long endTime);
	
	default List<CoinmLongShortAccountRatio> getTopTraderAccountRatio(String pair, Period period, Integer limit){
		return getTopTraderAccountRatio(pair, period, limit, null, null);
	}
	
	//Top Trader Long/Short Ratio (Positions)
	@ApiEndpoint (
			endpoint = "/futures/data/topLongShortPositionRatio",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<CoinmLongShortPositionRatio> getTopTraderPositionRatio(String pair, Period period, Integer limit, Long startTime, Long endTime);

	default List<CoinmLongShortPositionRatio> getTopTraderPositionRatio(String pair, Period period, Integer limit){
		return getTopTraderPositionRatio(pair, period, limit, null, null);
	}
	
	//Long/Short Ratio
	@ApiEndpoint (
			endpoint = "/futures/data/globalLongShortAccountRatio",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<CoinmLongShortAccountRatio> getGlobalAccountRatio(String pair, Period period, Integer limit, Long startTime, Long endTime);
	
	default List<CoinmLongShortAccountRatio> getGlobalAccountRatio(String pair, Period period, Integer limit){
		return getGlobalAccountRatio(pair, period, limit, null, null);
	}
	
	//Taker Buy/Sell Volume
	@ApiEndpoint (
			endpoint = "/futures/data/takerBuySellVol",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.contractType, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, true, false, false, false}
	)
	public List<CoinmTakerVolume> getTakerBuySellVolume(String pair, ContractTypes contractType, Period period, Integer limit, Long startTime, Long endTime);

	default List<CoinmTakerVolume> getTakerBuySellVolume(String pair, ContractTypes contractType, Period period, Integer limit){
		return getTakerBuySellVolume(pair, contractType, period, limit, null, null);
	}
	
	//Basis
	@ApiEndpoint (
			endpoint = "/futures/data/basis",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.contractType, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, true, false, false, false}
	)
	public List<Basis> getBasis(String pair, ContractTypes contractType, Period period, Integer limit, Long startTime, Long endTime);

	default List<Basis> getBasis(String pair, ContractTypes contractType, Period period, Integer limit){
		return getBasis(pair, contractType, period, limit, null, null);
	}
}