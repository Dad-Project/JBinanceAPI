package fr.rowlaxx.binanceapi.api.coinm;

import java.util.List;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.CompressedTrade;
import fr.rowlaxx.binanceapi.core.FinalOrderBook;
import fr.rowlaxx.binanceapi.core.coinm.marketdata.CoinmExchangeInformation;
import fr.rowlaxx.binanceapi.core.coinm.marketdata.CoinmTrade;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;

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

	@ApiEndpoint (
			endpoint = "/dapi/v1/premiumIndex",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.pair},
			mandatory = {false, false}
	)
	public List<IndexPriceandMarkPrice> getIndexPriceandMarkPrice(String symbol, String pair);

	@ApiEndpoint (
			endpoint = "/dapi/v1/fundingRate",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false}
	)
	public List<GetFundingRateHistoryofPerpetualFutures> getGetFundingRateHistoryofPerpetualFutures(String symbol, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/dapi/v1/klines",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<KlineCandlestickData> getKlineCandlestickData(String symbol, Enum interval, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/dapi/v1/continuousKlines",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.contractType, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, true, false, false, false}
	)
	public List<ContinuousContractKlineCandlestickData> getContinuousContractKlineCandlestickData(String pair, Enum contractType, Enum interval, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/dapi/v1/indexPriceKlines",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<IndexPriceKlineCandlestickData> getIndexPriceKlineCandlestickData(String pair, Enum interval, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/dapi/v1/markPriceKlines",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<MarkPriceKlineCandlestickData> getMarkPriceKlineCandlestickData(String symbol, Enum interval, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/dapi/v1/ticker/24hr",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.pair},
			mandatory = {false, false}
	)
	public List<24hrTickerPriceChangeStatistics> get24hrTickerPriceChangeStatistics(String symbol, String pair);

	@ApiEndpoint (
			endpoint = "/dapi/v1/ticker/price",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.pair},
			mandatory = {false, false}
	)
	public List<SymbolPriceTicker> getSymbolPriceTicker(String symbol, String pair);

	@ApiEndpoint (
			endpoint = "/dapi/v1/ticker/bookTicker",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.pair},
			mandatory = {false, false}
	)
	public List<SymbolOrderBookTicker> getSymbolOrderBookTicker(String symbol, String pair);

	@ApiEndpoint (
			endpoint = "/dapi/v1/openInterest",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public OpenInterest getOpenInterest(String symbol);

	@ApiEndpoint (
			endpoint = "/futures/data/openInterestHist",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.contractType, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, true, false, false, false}
	)
	public List<OpenInterestStatistics> getOpenInterestStatistics(String pair, Enum contractType, Enum period, long limit, long startTime, long endTime);

	@ApiEndpoint (
			endpoint = "/futures/data/topLongShortAccountRatio",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<TopTraderLongShortRatio> getTopTraderLongShortRatio(String pair, Enum period, long limit, long startTime, long endTime);

	@ApiEndpoint (
			endpoint = "/futures/data/topLongShortPositionRatio",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<TopTraderLongShortRatio> getTopTraderLongShortRatio(String pair, Enum period, long limit, long startTime, long endTime);

	@ApiEndpoint (
			endpoint = "/futures/data/globalLongShortAccountRatio",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<LongShortRatio> getLongShortRatio(String pair, Enum period, long limit, long startTime, long endTime);

	@ApiEndpoint (
			endpoint = "/futures/data/takerBuySellVol",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.contractType, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, true, false, false, false}
	)
	public List<TakerBuySellVolume> getTakerBuySellVolume(String pair, Enum contractType, Enum period, long limit, long startTime, long endTime);

	@ApiEndpoint (
			endpoint = "/futures/data/basis",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.contractType, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, true, false, false, false}
	)
	public List<Basis> getBasis(String pair, Enum contractType, Enum period, long limit, long startTime, long endTime);



}
