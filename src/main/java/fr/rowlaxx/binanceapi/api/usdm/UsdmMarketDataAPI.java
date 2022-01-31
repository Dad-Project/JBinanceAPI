package fr.rowlaxx.binanceapi.api.usdm;

import java.util.List;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.CompressedTrade;
import fr.rowlaxx.binanceapi.core.FinalOrderBook;
import fr.rowlaxx.binanceapi.core.usdm.marketdata.UsdmExchangeInformation;
import fr.rowlaxx.binanceapi.core.usdm.marketdata.UsdmTrade;

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

	@ApiEndpoint (
			endpoint = "/fapi/v1/klines",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<KlineCandlestickData> getKlineCandlestickData(String symbol, Enum interval, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/fapi/v1/continuousKlines",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.contractType, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, true, false, false, false}
	)
	public List<ContinuousContractKlineCandlestickData> getContinuousContractKlineCandlestickData(String pair, Enum contractType, Enum interval, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/fapi/v1/indexPriceKlines",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.pair, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<IndexPriceKlineCandlestickData> getIndexPriceKlineCandlestickData(String pair, Enum interval, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/fapi/v1/markPriceKlines",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<MarkPriceKlineCandlestickData> getMarkPriceKlineCandlestickData(String symbol, Enum interval, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/fapi/v1/premiumIndex",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public MarkPrice getMarkPrice(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/premiumIndex",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<MarkPrice1> getMarkPrice1(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/fundingRate",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false}
	)
	public List<GetFundingRateHistory> getGetFundingRateHistory(String symbol, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/fapi/v1/ticker/24hr",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public 24hrTickerPriceChangeStatistics get24hrTickerPriceChangeStatistics(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/ticker/24hr",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<24hrTickerPriceChangeStatistics1> get24hrTickerPriceChangeStatistics1(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/ticker/price",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public SymbolPriceTicker getSymbolPriceTicker(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/ticker/price",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<SymbolPriceTicker1> getSymbolPriceTicker1(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/ticker/bookTicker",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public SymbolOrderBookTicker getSymbolOrderBookTicker(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/ticker/bookTicker",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<SymbolOrderBookTicker1> getSymbolOrderBookTicker1(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/openInterest",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public OpenInterest getOpenInterest(String symbol);

	@ApiEndpoint (
			endpoint = "/futures/data/openInterestHist",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<OpenInterestStatistics> getOpenInterestStatistics(String symbol, Enum period, long limit, long startTime, long endTime);

	@ApiEndpoint (
			endpoint = "/futures/data/topLongShortAccountRatio",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<TopTraderLongShortRatio> getTopTraderLongShortRatio(String symbol, Enum period, long limit, long startTime, long endTime);

	@ApiEndpoint (
			endpoint = "/futures/data/topLongShortPositionRatio",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<TopTraderLongShortRatio> getTopTraderLongShortRatio(String symbol, Enum period, long limit, long startTime, long endTime);

	@ApiEndpoint (
			endpoint = "/futures/data/globalLongShortAccountRatio",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<LongShortRatio> getLongShortRatio(String symbol, Enum period, long limit, long startTime, long endTime);

	@ApiEndpoint (
			endpoint = "/futures/data/takerlongshortRatio",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.period, Parameters.limit, Parameters.startTime, Parameters.endTime},
			mandatory = {true, true, false, false, false}
	)
	public List<TakerBuySellVolume> getTakerBuySellVolume(String symbol, Enum period, long limit, long startTime, long endTime);

	@ApiEndpoint (
			endpoint = "/fapi/v1/lvtKlines",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	public List<HistoricalBLVTNAVKlineCandlestick> getHistoricalBLVTNAVKlineCandlestick(String symbol, Enum interval, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/fapi/v1/indexInfo",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<CompositeIndexSymbolInformation> getCompositeIndexSymbolInformation(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/assetIndex",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public MultiAssetsModeAssetIndex getMultiAssetsModeAssetIndex(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/assetIndex",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<MultiAssetsModeAssetIndex1> getMultiAssetsModeAssetIndex1(String symbol);
}
