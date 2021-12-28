package fr.rowlaxx.binanceapi.interfaces.api.options;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.general.options.OptionExchangeInformation;
import fr.rowlaxx.binanceapi.core.general.options.OptionTradingPairInfo;
import fr.rowlaxx.binanceapi.core.market.FinalOrderBook;
import fr.rowlaxx.binanceapi.core.market.Intervals;
import fr.rowlaxx.binanceapi.core.market.options.LatestMarkPrice;
import fr.rowlaxx.binanceapi.core.market.options.LatestPrice;
import fr.rowlaxx.binanceapi.core.market.options.OptionsCandlestick;
import fr.rowlaxx.binanceapi.core.market.options.OptionsTrade;
import fr.rowlaxx.jsavon.annotations.MapKey;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;

public interface OptionsQuotingInterfaces {

	@ApiEndpoint (
			endpoint = "/vapi/v1/ping",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "msg")
	public String testConnectivity();

	@ApiEndpoint (
			endpoint = "/vapi/v1/time",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "data")
	public long getServerTime();

	@ApiEndpoint (
			endpoint = "/vapi/v1/optionInfo",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "data")
	@MapKey(fieldName = "symbol")
	public Map<String, OptionTradingPairInfo> getCurrentTradingPairInfo();

	@ApiEndpoint (
			endpoint = "/vapi/v1/exchangeInfo",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "data")
	public OptionExchangeInformation getExchangeInformations();

	@ApiEndpoint (
			endpoint = "/vapi/v1/index",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.underlying},
			mandatory = {true}
	)
	@RedirectResponse(path = "data/indexPrice")
	public double getSpotIndexPrice(String underlying);

	@ApiEndpoint (
			endpoint = "/vapi/v1/ticker",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	@RedirectResponse(path = "/data/%INDEX=0%")
	public LatestPrice getLatestPrice(String symbol);

	@ApiEndpoint (
			endpoint = "/vapi/v1/ticker",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "data")
	@MapKey(fieldName = "symbol")
	public Map<String, LatestPrice> getLatestPrice();

	
	@ApiEndpoint (
			endpoint = "/vapi/v1/mark",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	@RedirectResponse(path = "/data/%INDEX=0%")
	public LatestMarkPrice getLatestMarkPrice(String symbol);

	@ApiEndpoint (
			endpoint = "/vapi/v1/mark",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "data")
	@MapKey(fieldName = "symbol")
	public Map<String, LatestMarkPrice> getLatestMarkPrice();

	
	@ApiEndpoint (
			endpoint = "/vapi/v1/depth",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit},
			mandatory = {true, false}
	)
	@RedirectResponse(path = "data")
	public FinalOrderBook getDepth(String symbol, Integer limit);

	@ApiEndpoint (
			endpoint = "/vapi/v1/klines",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	@RedirectResponse(path = "data")
	public List<OptionsCandlestick> getCandledata(String symbol, Intervals interval, Long startTime, Long endTime, Integer limit);

	@ApiEndpoint (
			endpoint = "/vapi/v1/trades",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit},
			mandatory = {true, false}
	)
	@RedirectResponse(path = "data")
	public List<OptionsTrade> getRecentlyOptionTrades(String symbol, Integer limit);

	@ApiEndpoint (
			endpoint = "/vapi/v1/historicalTrades",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.fromId, Parameters.limit},
			mandatory = {true, false, false}
	)
	@RedirectResponse(path = "data")
	public List<OptionsTrade> getTradeHistory(String symbol, Long fromId, Integer limit);
}
