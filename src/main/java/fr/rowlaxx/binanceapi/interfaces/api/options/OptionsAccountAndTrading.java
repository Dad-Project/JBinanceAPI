package fr.rowlaxx.binanceapi.interfaces.api.options;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;

public interface OptionsAccountAndTrading {
/*
	@ApiEndpoint (
			endpoint = "/vapi/v1/account",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public Accountassetinfo getAccountassetinfo();

	@ApiEndpoint (
			endpoint = "/vapi/v1/transfer",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.currency, Parameters.type, Parameters.amount},
			mandatory = {true, true, true}
	)
	public Fundstransfer postFundstransfer(String currency, Enum type, double amount);

	@ApiEndpoint (
			endpoint = "/vapi/v1/position",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public Optionholdingsinfo getOptionholdingsinfo(String symbol);

	@ApiEndpoint (
			endpoint = "/vapi/v1/bill",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.currency, Parameters.recordId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public Accountfundingflow postAccountfundingflow(String currency, long recordId, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/vapi/v1/order",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.side, Parameters.type, Parameters.quantity, Parameters.price, Parameters.timeInForce, Parameters.reduceOnly, Parameters.postOnly, Parameters.newOrderRespType, Parameters.clientOrderId},
			mandatory = {true, true, true, true, false, false, false, false, false, false}
	)
	public Optionorder postOptionorder(String symbol, Enum side, Enum type, double quantity, double price, Enum timeInForce, boolean reduceOnly, boolean postOnly, Enum newOrderRespType, String clientOrderId);

	@ApiEndpoint (
			endpoint = "/vapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.orders, Parameters.symbol, Parameters.side, Parameters.type, Parameters.quantity, Parameters.price, Parameters.timeInForce, Parameters.reduceOnly, Parameters.postOnly, Parameters.newOrderRespType, Parameters.clientOrderId},
			mandatory = {true, true, true, true, true, false, false, false, false, false, false}
	)
	public PlaceMultipleOptionorders postPlaceMultipleOptionorders(List<Object> orders, String symbol, Enum side, Enum type, double quantity, double price, Enum timeInForce, boolean reduceOnly, boolean postOnly, Enum newOrderRespType, String clientOrderId);

	@ApiEndpoint (
			endpoint = "/vapi/v1/order",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.clientOrderId},
			mandatory = {true, false, false}
	)
	public CancelOptionorder deleteCancelOptionorder(String symbol, long orderId, String clientOrderId);

	@ApiEndpoint (
			endpoint = "/vapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderIds, Parameters.clientOrderIds},
			mandatory = {true, false, false}
	)
	public CancelMultipleOptionorders deleteCancelMultipleOptionorders(String symbol, List<Object> orderIds, List<Object> clientOrderIds);

	@ApiEndpoint (
			endpoint = "/vapi/v1/allOpenOrders",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public CancelallOptionorders deleteCancelallOptionorders(String symbol);

	@ApiEndpoint (
			endpoint = "/vapi/v1/order",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.clientOrderId},
			mandatory = {true, false, false}
	)
	public QueryOptionorder getQueryOptionorder(String symbol, long orderId, String clientOrderId);

	@ApiEndpoint (
			endpoint = "/vapi/v1/openOrders",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public QuerycurrentpendingOptionorders getQuerycurrentpendingOptionorders(String symbol, long orderId, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/vapi/v1/historyOrders",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public QueryOptionorderhistory getQueryOptionorderhistory(String symbol, long orderId, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/vapi/v1/userTrades",
			baseEndpoint = BaseEndpoints.VANILLA,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.fromId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public OptionTradeList getOptionTradeList(String symbol, long fromId, long startTime, long endTime, int limit);

*/}
