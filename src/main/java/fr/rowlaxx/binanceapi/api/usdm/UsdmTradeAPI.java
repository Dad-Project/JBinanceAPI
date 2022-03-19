package fr.rowlaxx.binanceapi.api.usdm;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.futures.trade.ADLQuantile;
import fr.rowlaxx.binanceapi.core.futures.trade.AutoCloseTypes;
import fr.rowlaxx.binanceapi.core.futures.trade.Brackets;
import fr.rowlaxx.binanceapi.core.futures.trade.FutureIncomeRecord;
import fr.rowlaxx.binanceapi.core.futures.trade.FutureOrderRequest;
import fr.rowlaxx.binanceapi.core.futures.trade.IncomeTypes;
import fr.rowlaxx.binanceapi.core.futures.trade.MarginChangeRecord;
import fr.rowlaxx.binanceapi.core.futures.trade.MarginTypes;
import fr.rowlaxx.binanceapi.core.futures.trade.PositionInformation;
import fr.rowlaxx.binanceapi.core.futures.trade.PositionSides;
import fr.rowlaxx.binanceapi.core.futures.trade.UserCommissionRate;
import fr.rowlaxx.binanceapi.core.usdm.trade.UsdmAccountBalance;
import fr.rowlaxx.binanceapi.core.usdm.trade.UsdmAccountInformation;
import fr.rowlaxx.binanceapi.core.usdm.trade.UsdmAccountTrade;
import fr.rowlaxx.binanceapi.core.usdm.trade.UsdmForceOrder;
import fr.rowlaxx.binanceapi.core.usdm.trade.UsdmOrder;
import fr.rowlaxx.binanceapi.core.wallet.Indicators;
import fr.rowlaxx.convertutils.MapKey;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;

public interface UsdmTradeAPI extends Api.Https, Api.Usdm {

	//Change Position Mode(TRADE)
	@ApiEndpoint (
			endpoint = "/fapi/v1/positionSide/dual",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.dualSidePosition},
			mandatory = {true}
	)
	@RedirectResponse(path = "msg")
	public String setDualSidePosition(Boolean dualSidePosition);

	//Get Current Position Mode(USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v1/positionSide/dual",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "dualSidePosition")
	public boolean isDualSidePosition();

	//Change Multi-Assets Mode (TRADE)
	@ApiEndpoint (
			endpoint = "/fapi/v1/multiAssetsMargin",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.multiAssetsMargin},
			mandatory = {true}
	)
	@RedirectResponse(path = "msg")
	public String setMultiAssetsMargin(Boolean multiAssetsMargin);

	//Get Current Multi-Assets Mode (USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v1/multiAssetsMargin",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "multiAssetsMargin")
	public boolean isMultiAssetsMargin();

	//New Order (TRADE)
	@ApiEndpoint (
			endpoint = "/fapi/v1/order",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.side, Parameters.positionSide, Parameters.type, Parameters.timeInForce, Parameters.quantity, Parameters.reduceOnly, Parameters.price, Parameters.newClientOrderId, Parameters.stopPrice, Parameters.closePosition, Parameters.activationPrice, Parameters.callbackRate, Parameters.workingType, Parameters.priceProtect, Parameters.newOrderRespType},
			mandatory = {true, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false}
	)
	public UsdmOrder postOrder(FutureOrderRequest request);
	
	//Place Multiple Orders (TRADE)
	@ApiEndpoint (
			endpoint = "/fapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.batchOrders},
			mandatory = {true}
	)
	public List<UsdmOrder> postOrders(List<FutureOrderRequest> requests);

	@ApiEndpoint (
			endpoint = "/fapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.batchOrders},
			mandatory = {true}
	)
	public List<UsdmOrder> postOrders(FutureOrderRequest[] requests);

	//Query Order (USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v1/order",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false}
	)
	public UsdmOrder getOrder(String symbol, Long orderId, String origClientOrderId);

	default UsdmOrder getOrder(String symbol, Long orderId) {
		return getOrder(symbol, orderId, null);
	}
	
	default UsdmOrder getOrder(String symbol, String origClientOrderId) {
		return getOrder(symbol, null, origClientOrderId);
	}
	
	//Cancel Order (TRADE)
	@ApiEndpoint (
			endpoint = "/fapi/v1/order",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false}
	)
	public UsdmOrder cancelOrder(String symbol, Long orderId, String origClientOrderId);

	default UsdmOrder cancelOrder(String symbol, Long orderId) {
		return cancelOrder(symbol, orderId, null);
	}
	
	default UsdmOrder cancelOrder(String symbol, String origClientOrderId) {
		return cancelOrder(symbol, null, origClientOrderId);
	}
	
	//Cancel All Open Orders (TRADE)
	@ApiEndpoint (
			endpoint = "/fapi/v1/allOpenOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	@RedirectResponse(path = "msg")
	public String cancelAllOpenOrders(String symbol);

	//Cancel Multiple Orders (TRADE)
	@ApiEndpoint (
			endpoint = "/fapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderIdList, Parameters.origClientOrderIdList},
			mandatory = {true, false, false}
	)
	public List<UsdmOrder> cancelMultipleOrders(String symbol, List<Long> orderIdList, List<String> origClientOrderIdList);

	@ApiEndpoint (
			endpoint = "/fapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderIdList, Parameters.origClientOrderIdList},
			mandatory = {true, false, false}
	)
	public List<UsdmOrder> cancelMultipleOrders(String symbol, Long[] orderIdList, String[] origClientOrderIdList);

	default List<UsdmOrder> cancelMultipleOrders(String symbol, Long... orderIdList){
		return cancelMultipleOrders(symbol, orderIdList, null);
	}
	
	default List<UsdmOrder> cancelMultipleOrders(String symbol, String... origClientOrderIdList){
		return cancelMultipleOrders(symbol, null, origClientOrderIdList);
	}
	
	//Auto-Cancel All Open Orders (TRADE)
	@ApiEndpoint (
			endpoint = "/fapi/v1/countdownCancelAll",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.countdownTime},
			mandatory = {true, true}
	)
	public void autoCancelAllOpenOrders(String symbol, Long countdownTime);

	//Query Current Open Order (USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v1/openOrder",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false}
	)
	public UsdmOrder getOpenOrder(String symbol, Long orderId, String origClientOrderId);

	default UsdmOrder getOpenOrder(String symbol, Long orderId) {
		return getOpenOrder(symbol, orderId, null);
	}
	
	default UsdmOrder getOpenOrder(String symbol, String origClientOrderId) {
		return getOpenOrder(symbol, null, origClientOrderId);
	}
	
	//Current All Open Orders (USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v1/openOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public List<UsdmOrder> getOpenOrders(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/openOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public List<UsdmOrder> getOpenOrders();

	//All Orders (USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v1/allOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<UsdmOrder> getAllOrders(String symbol, Long orderId, Long startTime, Long endTime, Integer limit);

	default List<UsdmOrder> getAllOrders(String symbol, Long orderId, Integer limit){
		return getAllOrders(symbol, orderId, null, null, limit);
	}
	
	//Futures Account Balance V2 (USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v2/balance",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "asset")
	public Map<String, UsdmAccountBalance> getAccountBalances();
	
	default UsdmAccountBalance getAccountBalance(String asset) {
		return getAccountBalances().get(asset);
	}
	
	//Account Information V2 (USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v2/account",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public UsdmAccountInformation getAccountInformation();

	//Change Initial Leverage (TRADE)
	@ApiEndpoint (
			endpoint = "/fapi/v1/leverage",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.leverage},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "maxNotionalValue")
	public long setInitialLeverage(String symbol, Integer leverage);

	//Change Margin Type (TRADE)
	@ApiEndpoint (
			endpoint = "/fapi/v1/marginType",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.marginType},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "msg")
	public String setMarginType(String symbol, MarginTypes marginType);

	//Modify Isolated Position Margin (TRADE)
	@ApiEndpoint (
			endpoint = "/fapi/v1/positionMargin",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.positionSide, Parameters.amount, Parameters.type},
			mandatory = {true, false, true, true}
	)
	@RedirectResponse(path = "msg")
	public String setIsolatedPositionMargin(String symbol, PositionSides positionSide, Double amount, Integer type);

	//Get Position Margin Change History (TRADE)
	@ApiEndpoint (
			endpoint = "/fapi/v1/positionMargin/history",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<MarginChangeRecord> getMarginChangeHistory(String symbol, Integer type, Long startTime, Long endTime, Integer limit);

	default List<MarginChangeRecord> getMarginChangeHistory(String symbol, Integer type, Integer limit){
		return getMarginChangeHistory(symbol, type, null, null, limit);
	}
	
	//Position Information V2 (USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v2/positionRisk",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<PositionInformation> getPositionInformation(String symbol);

	//Account Trade List (USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v1/userTrades",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.startTime, Parameters.endTime, Parameters.fromId, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<UsdmAccountTrade> getAccountTrades(String symbol, Long startTime, Long endTime, Long fromId, Integer limit);

	default List<UsdmAccountTrade> getAccountTrades(String symbol, Long fromId, Integer limit){
		return getAccountTrades(symbol, null, null, fromId, limit);
	}
	
	//Get Income History(USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v1/income",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.incomeType, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	public List<FutureIncomeRecord> getIncomeHistory(String symbol, IncomeTypes incomeType, Long startTime, Long endTime, Integer limit);

	default List<FutureIncomeRecord> getIncomeHistory(String symbol, IncomeTypes incomeType, Integer limit){
		return getIncomeHistory(symbol, incomeType, null, null, limit);
	}
	
	//Notional and Leverage Brackets (USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v1/leverageBracket",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, Brackets> getBrackets();

	@ApiEndpoint (
			endpoint = "/fapi/v1/leverageBracket",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public Brackets getBrackets(String symbol);
	
	//Position ADL Quantile Estimation (USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v1/adlQuantile",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public ADLQuantile getADLQuantile(String symbol);

	@ApiEndpoint (
			endpoint = "/dapi/v1/adlQuantile",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, ADLQuantile> getADLQuantiles();
	
	//User's Force Orders (USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v1/forceOrders",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.autoCloseType, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	public List<UsdmForceOrder> getUsersForceOrders(String symbol, AutoCloseTypes autoCloseType, Long startTime, Long endTime, Integer limit);

	default List<UsdmForceOrder> getUsersForceOrders(String symbol, AutoCloseTypes autoCloseType, Integer limit){
		return getUsersForceOrders(symbol, autoCloseType, null, null, limit);
	}
	
	//User API Trading Quantitative Rules Indicators (USER_DATA)
	@ApiEndpoint (
			endpoint = "/fapi/v1/apiTradingStatus",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	@RedirectResponse(path = "indicators/%PARAMETER=symbol%")
	public Indicators getApiTradingStatus(String symbol);

	@ApiEndpoint (
			endpoint = "/fapi/v1/apiTradingStatus",
			baseEndpoint = BaseEndpoints.FUTURE_USD,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "indicators")
	public Map<String, Indicators> getApiTradingStatus();
	
	//User Commission Rate (USER_DATA)
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
