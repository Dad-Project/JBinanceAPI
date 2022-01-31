package fr.rowlaxx.binanceapi.api.coinm;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;

public interface CoinmTradeAPI extends Api.Coinm, Api.Https {

	//Change Position Mode(TRADE)
	@ApiEndpoint (
			endpoint = "/dapi/v1/positionSide/dual",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.dualSidePosition},
			mandatory = {true}
	)
	@RedirectResponse(path = "msg")
	public String setDualSidePosition(Boolean dualSidePosition);

	//Get Current Position Mode(USER_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v1/positionSide/dual",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "dualSidePosition")
	public boolean isDualSidePosition();

	//New Order (TRADE)
	@ApiEndpoint (
			endpoint = "/dapi/v1/order",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.side, Parameters.positionSide, Parameters.type, Parameters.timeInForce, Parameters.quantity, Parameters.reduceOnly, Parameters.price, Parameters.newClientOrderId, Parameters.stopPrice, Parameters.closePosition, Parameters.activationPrice, Parameters.callbackRate, Parameters.workingType, Parameters.priceProtect, Parameters.newOrderRespType},
			mandatory = {true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false}
	)
	public NewOrder postNewOrder(String symbol, Enum side, Enum positionSide, Enum type, Enum timeInForce, double quantity, String reduceOnly, double price, String newClientOrderId, double stopPrice, String closePosition, double activationPrice, double callbackRate, Enum workingType, String priceProtect, Enum newOrderRespType);

	@ApiEndpoint (
			endpoint = "/dapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.batchOrders, Parameters.symbol, Parameters.side, Parameters.positionSide, Parameters.type, Parameters.timeInForce, Parameters.quantity, Parameters.reduceOnly, Parameters.price, Parameters.newClientOrderId, Parameters.stopPrice, Parameters.activationPrice, Parameters.callbackRate, Parameters.workingType, Parameters.priceProtect, Parameters.newOrderRespType},
			mandatory = {true, true, true, false, true, false, true, false, false, false, false, false, false, false, false, false}
	)
	public List<PlaceMultipleOrders> postPlaceMultipleOrders(List<Object> batchOrders, String symbol, Enum side, Enum positionSide, Enum type, Enum timeInForce, double quantity, String reduceOnly, double price, String newClientOrderId, double stopPrice, double activationPrice, double callbackRate, Enum workingType, String priceProtect, Enum newOrderRespType);

	@ApiEndpoint (
			endpoint = "/dapi/v1/orderAmendment",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false, false}
	)
	public List<GetOrderModifyHistory> getGetOrderModifyHistory(String symbol, long orderId, String origClientOrderId, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/dapi/v1/order",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false}
	)
	public QueryOrder getQueryOrder(String symbol, long orderId, String origClientOrderId);

	@ApiEndpoint (
			endpoint = "/dapi/v1/order",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false}
	)
	public CancelOrder deleteCancelOrder(String symbol, long orderId, String origClientOrderId);

	@ApiEndpoint (
			endpoint = "/dapi/v1/allOpenOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public CancelAllOpenOrders deleteCancelAllOpenOrders(String symbol);

	@ApiEndpoint (
			endpoint = "/dapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderIdList, Parameters.origClientOrderIdList},
			mandatory = {true, false, false}
	)
	public List<CancelMultipleOrders> deleteCancelMultipleOrders(String symbol, List<Long> orderIdList, List<Long> origClientOrderIdList);

	@ApiEndpoint (
			endpoint = "/dapi/v1/countdownCancelAll",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.countdownTime},
			mandatory = {true, true}
	)
	public AutoCancelAllOpenOrders postAutoCancelAllOpenOrders(String symbol, long countdownTime);

	@ApiEndpoint (
			endpoint = "/dapi/v1/openOrder",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false}
	)
	public QueryCurrentOpenOrder getQueryCurrentOpenOrder(String symbol, long orderId, String origClientOrderId);

	@ApiEndpoint (
			endpoint = "/dapi/v1/openOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.pair},
			mandatory = {false, false}
	)
	public List<CurrentAllOpenOrders> getCurrentAllOpenOrders(String symbol, String pair);

	@ApiEndpoint (
			endpoint = "/dapi/v1/allOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.pair, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<AllOrders> getAllOrders(String symbol, String pair, long orderId, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/dapi/v1/balance",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public List<FuturesAccountBalance> getFuturesAccountBalance();

	@ApiEndpoint (
			endpoint = "/dapi/v1/account",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public AccountInformation getAccountInformation();

	@ApiEndpoint (
			endpoint = "/dapi/v1/leverage",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.leverage},
			mandatory = {true, true}
	)
	public ChangeInitialLeverage postChangeInitialLeverage(String symbol, int leverage);

	@ApiEndpoint (
			endpoint = "/dapi/v1/marginType",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.marginType},
			mandatory = {true, true}
	)
	public ChangeMarginType postChangeMarginType(String symbol, Enum marginType);

	@ApiEndpoint (
			endpoint = "/dapi/v1/positionMargin",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.positionSide, Parameters.amount, Parameters.type},
			mandatory = {true, false, true, true}
	)
	public ModifyIsolatedPositionMargin postModifyIsolatedPositionMargin(String symbol, Enum positionSide, double amount, int type);

	@ApiEndpoint (
			endpoint = "/dapi/v1/positionMargin/history",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<GetPositionMarginChangeHistory> getGetPositionMarginChangeHistory(String symbol, int type, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/dapi/v1/positionRisk",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.marginAsset, Parameters.pair},
			mandatory = {false, false}
	)
	public List<PositionInformation> getPositionInformation(String marginAsset, String pair);

	@ApiEndpoint (
			endpoint = "/dapi/v1/userTrades",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.pair, Parameters.startTime, Parameters.endTime, Parameters.fromId, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<AccountTradeList> getAccountTradeList(String symbol, String pair, long startTime, long endTime, long fromId, int limit);

	@ApiEndpoint (
			endpoint = "/dapi/v1/income",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.incomeType, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	public List<GetIncomeHistory> getGetIncomeHistory(String symbol, String incomeType, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/dapi/v1/leverageBracket",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.pair},
			mandatory = {false}
	)
	public List<NotionalBracketforSymbol> getNotionalBracketforSymbol(String pair);

	@ApiEndpoint (
			endpoint = "/dapi/v2/leverageBracket",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<NotionalBracketforPair> getNotionalBracketforPair(String symbol);

	@ApiEndpoint (
			endpoint = "/dapi/v1/forceOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.autoCloseType, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	public List<UsersForceOrders> getUsersForceOrders(String symbol, Enum autoCloseType, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/dapi/v1/adlQuantile",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<PositionADLQuantileEstimation> getPositionADLQuantileEstimation(String symbol);

	@ApiEndpoint (
			endpoint = "/dapi/v1/commissionRate",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public UserCommissionRate getUserCommissionRate(String symbol);



}
