package fr.rowlaxx.binanceapi.api.options;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.FinalOrderBook;
import fr.rowlaxx.binanceapi.core.Intervals;
import fr.rowlaxx.binanceapi.core.options.quoting.ExerciceRecord;
import fr.rowlaxx.binanceapi.core.options.quoting.LatestMarkPrice;
import fr.rowlaxx.binanceapi.core.options.quoting.LatestPrice;
import fr.rowlaxx.binanceapi.core.options.quoting.OptionExchangeInformation;
import fr.rowlaxx.binanceapi.core.options.quoting.OptionTradingPair;
import fr.rowlaxx.binanceapi.core.options.quoting.OptionCandlestick;
import fr.rowlaxx.binanceapi.core.options.quoting.OptionTrade;
import fr.rowlaxx.jsavon.annotations.MapKey;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;

/**
 * @version 2022-01-30
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/voptions/en/#quoting-interface
 */
public interface OptionsQuotingAPI extends Api.Options, Api.Https {

	//Test connectivity
	@ApiEndpoint (
			endpoint = "/vapi/v1/ping",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "msg")
	public String ping();

	//Get server time
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

	//Get current trading pair info
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
	public Map<String, OptionTradingPair> getCurrentTradingPairs();

	//Get current limit info and trading pair info
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

	//Get the spot index price
	@ApiEndpoint (
			endpoint = "/vapi/v1/index",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.underlying},
			mandatory = {true}
	)
	@RedirectResponse(path = "data/indexPrice")
	public double getIndexPrice(String underlying);

	//Get the latest price
	@ApiEndpoint (
			endpoint = "/vapi/v1/ticker",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
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
	public Map<String, LatestPrice> getLatestPrices();

	//Get the latest mark price
	@ApiEndpoint (
			endpoint = "/vapi/v1/mark",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
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
	public Map<String, LatestMarkPrice> getLatestMarkPrices();

	//Depth information
	@ApiEndpoint (
			endpoint = "/vapi/v1/depth",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit},
			mandatory = {true, false}
	)
	@RedirectResponse(path = "data")
	public FinalOrderBook getOrderbook(String symbol, Integer limit);

	//Candle data
	@ApiEndpoint (
			endpoint = "/vapi/v1/klines",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.interval, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, true, false, false, false}
	)
	@RedirectResponse(path = "data")
	public List<OptionCandlestick> getCandlesticks(String symbol, Intervals interval, Long startTime, Long endTime, Integer limit);

	default List<OptionCandlestick> getCandlesticks(String symbol, Intervals interval, Integer limit){
		return getCandlesticks(symbol, interval, null, null, limit);
	}
	
	//Recently completed Option trades
	@ApiEndpoint (
			endpoint = "/vapi/v1/trades",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.limit},
			mandatory = {true, false}
	)
	@RedirectResponse(path = "data")
	public List<OptionTrade> getRecentTrades(String symbol, Integer limit);

	//Query trade history
	@ApiEndpoint (
			endpoint = "/vapi/v1/historicalTrades",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.fromId, Parameters.limit},
			mandatory = {true, false, false}
	)
	@RedirectResponse(path = "data")
	public List<OptionTrade> getTradeHistory(String symbol, Long fromId, Integer limit);
	
	//Query historical exercise records
	@ApiEndpoint (
			endpoint = "/vapi/v1/exerciseHistory",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false}
	)
	@RedirectResponse(path = "data")
	public List<ExerciceRecord> getExerciceHistory(Long startTime, Long endTime, Integer limit);
}
