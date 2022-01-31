package fr.rowlaxx.binanceapi.api.usdm;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;

public interface UsdmTradeAPI extends Api.Https, Api.Usdm {

	@ApiEndpoint (
			endpoint = "/fapi/v1/positionSide/dual",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.dualSidePosition},
			mandatory = {true}
	)
	public ChangePositionMode postChangePositionMode(String dualSidePosition);

	@ApiEndpoint (
			endpoint = "/fapi/v1/positionSide/dual",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public GetCurrentPositionMode getGetCurrentPositionMode();

	@ApiEndpoint (
			endpoint = "/fapi/v1/multiAssetsMargin",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.multiAssetsMargin},
			mandatory = {true}
	)
	public ChangeMultiAssetsMode postChangeMultiAssetsMode(String multiAssetsMargin);

	@ApiEndpoint (
			endpoint = "/fapi/v1/multiAssetsMargin",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public GetCurrentMultiAssetsMode getGetCurrentMultiAssetsMode();

	@ApiEndpoint (
			endpoint = "/fapi/v1/order",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.side, Parameters.positionSide, Parameters.type, Parameters.timeInForce, Parameters.quantity, Parameters.reduceOnly, Parameters.price, Parameters.newClientOrderId, Parameters.stopPrice, Parameters.closePosition, Parameters.activationPrice, Parameters.callbackRate, Parameters.workingType, Parameters.priceProtect, Parameters.newOrderRespType},
			mandatory = {true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false}
	)
	public NewOrder postNewOrder(String symbol, Enum side, Enum positionSide, Enum type, Enum timeInForce, double quantity, String reduceOnly, double price, String newClientOrderId, double stopPrice, String closePosition, double activationPrice, double callbackRate, Enum workingType, String priceProtect, Enum newOrderRespType);

	@ApiEndpoint (
			endpoint = "/fapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.batchOrders, Parameters.symbol, Parameters.side, Parameters.positionSide, Parameters.type, Parameters.timeInForce, Parameters.quantity, Parameters.reduceOnly, Parameters.price, Parameters.newClientOrderId, Parameters.stopPrice, Parameters.activationPrice, Parameters.callbackRate, Parameters.workingType, Parameters.priceProtect, Parameters.newOrderRespType},
			mandatory = {true, true, true, false, true, false, true, false, false, false, false, false, false, false, false, false}
	)
	public List<PlaceMultipleOrders> postPlaceMultipleOrders(List<Object> batchOrders, String symbol, Enum side, Enum positionSide, Enum type, Enum timeInForce, double quantity, String reduceOnly, double price, String newClientOrderId, double stopPrice, double activationPrice, double callbackRate, Enum workingType, String priceProtect, Enum newOrderRespType);

	@ApiEndpoint (
			endpoint = "/fapi/v1/order",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false}
	)
	public QueryOrder getQueryOrder(String symbol, long orderId, String origClientOrderId);

	@ApiEndpoint (
			endpoint = "/fapi/v1/order",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false}
	)
	public CancelOrder deleteCancelOrder(String symbol, long orderId, String origClientOrderId);

	@ApiEndpoint (
			endpoint = "/fapi/v1/allOpenOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public CancelAllOpenOrders deleteCancelAllOpenOrders(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderIdList, Parameters.origClientOrderIdList},
			mandatory = {true, false, false}
	)
	public List<CancelMultipleOrders> deleteCancelMultipleOrders(String symbol, List<Long> orderIdList, List<Long> origClientOrderIdList);

	@ApiEndpoint (
			endpoint = "/fapi/v1/countdownCancelAll",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.countdownTime},
			mandatory = {true, true}
	)
	public AutoCancelAllOpenOrders postAutoCancelAllOpenOrders(String symbol, long countdownTime);

	@ApiEndpoint (
			endpoint = "/fapi/v1/openOrder",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false}
	)
	public QueryCurrentOpenOrder getQueryCurrentOpenOrder(String symbol, long orderId, String origClientOrderId);

	@ApiEndpoint (
			endpoint = "/fapi/v1/openOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<CurrentAllOpenOrders> getCurrentAllOpenOrders(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/allOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<AllOrders> getAllOrders(String symbol, long orderId, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/fapi/v2/balance",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public List<FuturesAccountBalanceV2> getFuturesAccountBalanceV2();

	@ApiEndpoint (
			endpoint = "/fapi/v2/account",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public AccountInformationV2 getAccountInformationV2();

	@ApiEndpoint (
			endpoint = "/fapi/v1/leverage",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.leverage},
			mandatory = {true, true}
	)
	public ChangeInitialLeverage postChangeInitialLeverage(String symbol, int leverage);

	@ApiEndpoint (
			endpoint = "/fapi/v1/marginType",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.marginType},
			mandatory = {true, true}
	)
	public ChangeMarginType postChangeMarginType(String symbol, Enum marginType);

	@ApiEndpoint (
			endpoint = "/fapi/v1/positionMargin",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.positionSide, Parameters.amount, Parameters.type},
			mandatory = {true, false, true, true}
	)
	public ModifyIsolatedPositionMargin postModifyIsolatedPositionMargin(String symbol, Enum positionSide, double amount, int type);

	@ApiEndpoint (
			endpoint = "/fapi/v1/positionMargin/history",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<GetPositionMarginChangeHistory> getGetPositionMarginChangeHistory(String symbol, int type, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/fapi/v2/positionRisk",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<PositionInformationV2> getPositionInformationV2(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v2/positionRisk",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<PositionInformationV21> getPositionInformationV21(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/userTrades",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.startTime, Parameters.endTime, Parameters.fromId, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<AccountTradeList> getAccountTradeList(String symbol, long startTime, long endTime, long fromId, int limit);

	@ApiEndpoint (
			endpoint = "/fapi/v1/income",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.incomeType, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	public List<GetIncomeHistory> getGetIncomeHistory(String symbol, String incomeType, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/fapi/v1/leverageBracket",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<NotionalandLeverageBrackets> getNotionalandLeverageBrackets(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/leverageBracket",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public NotionalandLeverageBrackets1 getNotionalandLeverageBrackets1(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/adlQuantile",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<PositionADLQuantileEstimation> getPositionADLQuantileEstimation(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/forceOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.autoCloseType, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	public void getUsersForceOrders(String symbol, Enum autoCloseType, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/fapi/v1/apiTradingStatus",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public void getUserAPITradingQuantitativeRulesIndicators(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/commissionRate",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public UserCommissionRate getUserCommissionRate(String symbol);
}
