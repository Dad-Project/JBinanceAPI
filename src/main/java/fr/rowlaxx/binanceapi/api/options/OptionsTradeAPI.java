package fr.rowlaxx.binanceapi.api.options;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.options.trade.AccountAsset;
import fr.rowlaxx.binanceapi.core.options.trade.FundingFlow;
import fr.rowlaxx.binanceapi.core.options.trade.FundsTransferTypes;
import fr.rowlaxx.binanceapi.core.options.trade.OptionHolding;
import fr.rowlaxx.binanceapi.core.options.trade.OptionOrder;
import fr.rowlaxx.binanceapi.core.options.trade.OptionOrderRequest;
import fr.rowlaxx.binanceapi.core.options.trade.OptionUserTrade;
import fr.rowlaxx.convertutils.MapKey;

/**
 * @version 2022-01-30
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/voptions/en/#account-and-trading-interface
 */
public interface OptionsTradeAPI extends Api.Https, Api.Options {

	//Account asset info (USER_DATA)
	@ApiEndpoint (
			endpoint = "/vapi/v1/account",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "data")
	@MapKey(fieldName = "currency")
	public Map<String, AccountAsset> getAccountAssets();

	//Funds transfer (USER_DATA)
	@ApiEndpoint (
			endpoint = "/vapi/v1/transfer",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.currency, Parameters.type, Parameters.amount},
			mandatory = {true, true, true}
	)
	@RedirectResponse(path = "data")
	public long transferFunds(String currency, FundsTransferTypes type, Double amount);

	//Option holdings info (USER_DATA)
	@ApiEndpoint (
			endpoint = "/vapi/v1/position",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	@RedirectResponse(path = "data/%INDEX=0%")
	public OptionHolding getHoldingInfo(String symbol);

	@ApiEndpoint (
			endpoint = "/vapi/v1/position",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "data/%INDEX=0%")
	@MapKey(fieldName = "symbol")
	public Map<String, OptionHolding> getHoldingInfos();
	
	//Account funding flow (USER_DATA)
	@ApiEndpoint (
			endpoint = "/vapi/v1/bill",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.currency, Parameters.recordId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	@RedirectResponse(path = "data")
	public List<FundingFlow> fundingflow(String currency, Long recordId, Long startTime, Long endTime, Integer limit);

	//Option order (TRADE)
	@ApiEndpoint (
			endpoint = "/vapi/v1/order",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.side, Parameters.type, Parameters.quantity, Parameters.price, Parameters.timeInForce, Parameters.reduceOnly, Parameters.postOnly, Parameters.newOrderRespType, Parameters.clientOrderId},
			mandatory = {true, true, true, true, false, false, false, false, false, false}
	)
	@RedirectResponse(path = "data")
	public OptionOrder postOrder(OptionOrderRequest orderRequest);

	//Place Multiple Option orders (TRADE)
	@ApiEndpoint (
			endpoint = "/vapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.orders},
			mandatory = {true}
	)
	@RedirectResponse(path = "data")
	public List<OptionOrder> postOrders(Collection<OptionOrderRequest> orderRequests);

	@ApiEndpoint (
			endpoint = "/vapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.orders},
			mandatory = {true}
	)
	@RedirectResponse(path = "data")
	public List<OptionOrder> postOrders(OptionOrderRequest[] orderRequests);

	//Cancel Option order (TRADE)
	@ApiEndpoint (
			endpoint = "/vapi/v1/order",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.clientOrderId},
			mandatory = {true, false, false}
	)
	@RedirectResponse(path = "data")
	public OptionOrder cancelOrder(String symbol, Long orderId, String clientOrderId);

	//Cancel Multiple Option orders (TRADE)
	@ApiEndpoint (
			endpoint = "/vapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderIds, Parameters.clientOrderIds},
			mandatory = {true, false, false}
	)
	@RedirectResponse(path = "data")
	public List<OptionOrder> cancelOrders(String symbol, List<Long> orderIds, List<String> clientOrderIds);

	@ApiEndpoint (
			endpoint = "/vapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderIds, Parameters.clientOrderIds},
			mandatory = {true, false, false}
	)
	@RedirectResponse(path = "data")
	public List<OptionOrder> cancelOrders(String symbol, Long[] orderIds, String[] clientOrderIds);

	//Cancel all Option orders (TRADE)
	@ApiEndpoint (
			endpoint = "/vapi/v1/allOpenOrders",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public void cancelAllOrders(String symbol);

	//Query Option order (TRADE)
	@ApiEndpoint (
			endpoint = "/vapi/v1/order",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.clientOrderId},
			mandatory = {true, false, false}
	)
	@RedirectResponse(path = "data")
	public OptionOrder getOrder(String symbol, Long orderId, String clientOrderId);

	//Query current pending Option orders (TRADE)
	@ApiEndpoint (
			endpoint = "/vapi/v1/openOrders",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false}
	)
	@RedirectResponse(path = "data")
	public List<OptionOrder> getOpenOrders(String symbol, Long startTime, Long endTime, Integer limit);

	default List<OptionOrder> getOpenOrders(String symbol, Integer limit){
		return getOpenOrders(symbol, null, null, limit);
	}
	
	@ApiEndpoint (
			endpoint = "/vapi/v1/openOrders",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "data/%INDEX=0%")
	public OptionOrder getOpenOrder(String symbol, Long orderId);

	//Query Option order history (TRADE)
	@ApiEndpoint (
			endpoint = "/vapi/v1/historyOrders",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false}
	)
	@RedirectResponse(path = "data")
	public List<OptionOrder> getOrderHistory(String symbol, Long startTime, Long endTime, Integer limit);

	default List<OptionOrder> getOrderHistory(String symbol, Integer limit){
		return getOrderHistory(symbol, null, null, limit);
	}
	
	@ApiEndpoint (
			endpoint = "/vapi/v1/historyOrders",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "data/%INDEX=0%")
	public List<OptionOrder> getOrderRecord(String symbol, Long orderId);

	//Option Trade List (USER_DATA)
	@ApiEndpoint (
			endpoint = "/vapi/v1/userTrades",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.fromId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)	
	@RedirectResponse(path = "data")
	public List<OptionUserTrade> getTrades(String symbol, Long fromId, Long startTime, Long endTime, Integer limit);

	default List<OptionUserTrade> getTrades(String symbol, Long fromId, Integer limit){
		return getTrades(symbol, fromId, null, null, limit);
	}
}