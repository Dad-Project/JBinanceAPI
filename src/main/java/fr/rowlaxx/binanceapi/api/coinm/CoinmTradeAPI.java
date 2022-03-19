package fr.rowlaxx.binanceapi.api.coinm;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.OrderSides;
import fr.rowlaxx.binanceapi.core.coinm.trade.CoinmAccountBalance;
import fr.rowlaxx.binanceapi.core.coinm.trade.CoinmAccountInformation;
import fr.rowlaxx.binanceapi.core.coinm.trade.CoinmAccountTrade;
import fr.rowlaxx.binanceapi.core.coinm.trade.CoinmForceOrder;
import fr.rowlaxx.binanceapi.core.coinm.trade.CoinmOrder;
import fr.rowlaxx.binanceapi.core.coinm.trade.ModifyOrderRequest;
import fr.rowlaxx.binanceapi.core.coinm.trade.OrderModifyRecord;
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
import fr.rowlaxx.convertutils.MapKey;

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
	public CoinmOrder postOrder(FutureOrderRequest request);

	//Modify Order (TRADE)
	@ApiEndpoint (
			endpoint = "/dapi/v1/order",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.PUT,
			needSignature = true,
			parameters = {Parameters.origClientOrderId, Parameters.symbol, Parameters.side, Parameters.quantity, Parameters.price},
			mandatory = {true, true, true, false, false}
	)
	public CoinmOrder modifyOrder(String origClientOrderId, String symbol, OrderSides side, Double quantity, Double price);
	
	@ApiEndpoint (
			endpoint = "/dapi/v1/order",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.PUT,
			needSignature = true,
			parameters = {Parameters.orderId, Parameters.symbol, Parameters.side, Parameters.quantity, Parameters.price},
			mandatory = {true, true, true, false, false}
	)
	public CoinmOrder modifyOrder(Long orderId, String symbol, OrderSides side, Double quantity, Double price);
	
	@ApiEndpoint (
			endpoint = "/dapi/v1/order",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.PUT,
			needSignature = true,
			parameters = {Parameters.orderId, Parameters.origClientOrderId, Parameters.symbol, Parameters.side, Parameters.quantity, Parameters.price},
			mandatory = {false, false, true, true, false, false}
	)
	public CoinmOrder modifyOrder(ModifyOrderRequest request);
	
	//Place Multiple Orders (TRADE)
	@ApiEndpoint (
			endpoint = "/dapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.batchOrders},
			mandatory = {true}
	)
	public List<CoinmOrder> postOrders(List<FutureOrderRequest> requests);

	@ApiEndpoint (
			endpoint = "/dapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.batchOrders},
			mandatory = {true}
	)
	public List<CoinmOrder> postOrders(FutureOrderRequest[] requests);
	
	//Modify Multiple Orders (TRADE)
	@ApiEndpoint (
			endpoint = "/dapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.PUT,
			needSignature = true,
			parameters = {Parameters.batchOrders},
			mandatory = {true}
	)
	public List<CoinmOrder> modifyOrders(ModifyOrderRequest[] requests);
	
	@ApiEndpoint (
			endpoint = "/dapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.PUT,
			needSignature = true,
			parameters = {Parameters.batchOrders},
			mandatory = {true}
	)
	public List<CoinmOrder> modifyOrders(Collection<ModifyOrderRequest> requests);
	
	//Get Order Modify History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v1/orderAmendment",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false, false}
	)
	public List<OrderModifyRecord> getOrderModifyHistory(String symbol, Long orderId, String origClientOrderId, Long startTime, Long endTime, Integer limit);

	default List<OrderModifyRecord> getOrderModifyHistory(String symbol, Long orderId, String origClientOrderId, Integer limit){
		return getOrderModifyHistory(symbol, orderId, origClientOrderId, null, null, limit);
	}
	
	//Query Order (USER_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v1/order",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false}
	)
	public CoinmOrder getOrder(String symbol, Long orderId, String origClientOrderId);

	default CoinmOrder getOrder(String symbol, Long orderId) {
		return getOrder(symbol, orderId, null);
	}
	
	default CoinmOrder getOrder(String symbol, String origClientOrderId) {
		return getOrder(symbol, null, origClientOrderId);
	}
	
	//Cancel Order (TRADE)
	@ApiEndpoint (
			endpoint = "/dapi/v1/order",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false}
	)
	public CoinmOrder cancelOrder(String symbol, Long orderId, String origClientOrderId);

	default CoinmOrder cancelOrder(String symbol, Long orderId) {
		return cancelOrder(symbol, orderId, null);
	}
	
	default CoinmOrder cancelOrder(String symbol, String origClientOrderId) {
		return cancelOrder(symbol, null, origClientOrderId);
	}
	
	//Cancel All Open Orders (TRADE)
	@ApiEndpoint (
			endpoint = "/dapi/v1/allOpenOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	@RedirectResponse(path = "msg")
	public String cancelAllOpenOrders(String symbol);

	//Cancel Multiple Orders (TRADE)
	@ApiEndpoint (
			endpoint = "/dapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderIdList, Parameters.origClientOrderIdList},
			mandatory = {true, false, false}
	)
	public List<CoinmOrder> cancelMultipleOrders(String symbol, List<Long> orderIdList, List<String> origClientOrderIdList);

	@ApiEndpoint (
			endpoint = "/dapi/v1/batchOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderIdList, Parameters.origClientOrderIdList},
			mandatory = {true, false, false}
	)
	public List<CoinmOrder> cancelMultipleOrders(String symbol, Long[] orderIdList, String[] origClientOrderIdList);
	
	default List<CoinmOrder> cancelMultipleOrders(String symbol, Long... orderIdList){
		return cancelMultipleOrders(symbol, orderIdList, null);
	}
	
	default List<CoinmOrder> cancelMultipleOrders(String symbol, String... origClientOrderIdList){
		return cancelMultipleOrders(symbol, null, origClientOrderIdList);
	}
	
	//Auto-Cancel All Open Orders (TRADE)
	@ApiEndpoint (
			endpoint = "/dapi/v1/countdownCancelAll",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.countdownTime},
			mandatory = {true, true}
	)
	public void autoCancelAllOpenOrders(String symbol, Long countdownTime);

	//Query Current Open Order (USER_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v1/openOrder",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false}
	)
	public CoinmOrder getOpenOrder(String symbol, Long orderId, String origClientOrderId);

	default CoinmOrder getOpenOrder(String symbol, Long orderId) {
		return getOpenOrder(symbol, orderId, null);
	}
	
	default CoinmOrder getOpenOrder(String symbol, String origClientOrderId) {
		return getOpenOrder(symbol, null, origClientOrderId);
	}
	
	//Current All Open Orders (USER_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v1/openOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.pair},
			mandatory = {false, false}
	)
	public List<CoinmOrder> getOpenOrders(String symbol, String pair);

	default List<CoinmOrder> getOpenOrders(String symbol){
		return getOpenOrders(symbol, null);
	}
	
	default List<CoinmOrder> getOpenOrders(){
		return getOpenOrders(null, null);
	}

	//All Orders (USER_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v1/allOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.pair, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<CoinmOrder> getAllOrders(String symbol, String pair, Long orderId, Long startTime, Long endTime, Integer limit);

	default List<CoinmOrder> getAllOrders(String symbol, String pair, Long orderId, Integer limit){
		return getAllOrders(symbol, pair, orderId, null, null, limit);
	}
	
	//Futures Account Balance (USER_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v1/balance",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "asset")
	public Map<String, CoinmAccountBalance> getAccountBalances();
	
	default CoinmAccountBalance getAccountBalance(String asset) {
		return getAccountBalances().get(asset);
	}

	//Account Information (USER_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v1/account",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public CoinmAccountInformation getAccountInformation();

	//Change Initial Leverage (TRADE)
	@ApiEndpoint (
			endpoint = "/dapi/v1/leverage",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.leverage},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "maxQty")
	public long setInitialLeverage(String symbol, Integer leverage);

	//Change Margin Type (TRADE)
	@ApiEndpoint (
			endpoint = "/dapi/v1/marginType",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.marginType},
			mandatory = {true, true}
	)
	@RedirectResponse(path = "msg")
	public String setMarginType(String symbol, MarginTypes marginType);

	//Modify Isolated Position Margin (TRADE)
	@ApiEndpoint (
			endpoint = "/dapi/v1/positionMargin",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.positionSide, Parameters.amount, Parameters.type},
			mandatory = {true, false, true, true}
	)
	@RedirectResponse(path = "msg")
	public String setIsolatedPositionMargin(String symbol, PositionSides positionSide, Double amount, Integer type);

	//Get Position Margin Change History (TRADE)
	@ApiEndpoint (
			endpoint = "/dapi/v1/positionMargin/history",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
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
			endpoint = "/dapi/v1/positionRisk",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.marginAsset, Parameters.pair},
			mandatory = {false, false}
	)
	public List<PositionInformation> getPositionInformation(String marginAsset, String pair);

	//Account Trade List (USER_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v1/userTrades",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.pair, Parameters.startTime, Parameters.endTime, Parameters.fromId, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<CoinmAccountTrade> getAccountTrades(String symbol, String pair, Long startTime, Long endTime, Long fromId, Integer limit);

	default List<CoinmAccountTrade> getAccountTrades(String symbol, String pair, Long fromId, Integer limit){
		return getAccountTrades(symbol, pair, null, null, fromId, limit);
	}
	
	//Get Income History(USER_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v1/income",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.incomeType, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	public List<FutureIncomeRecord> getIncomeHistory(String symbol, IncomeTypes incomeType, Long startTime, Long endTime, Integer limit);

	default List<FutureIncomeRecord> getIncomeHistory(String symbol, IncomeTypes incomeType, Integer limit){
		return getIncomeHistory(symbol, incomeType, null, null, limit);
	}
	
	//Notional Bracket for Pair(USER_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v1/leverageBracket",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.pair},
			mandatory = {false}
	)
	public List<Brackets> getBracketsPair(String pair);

	//Notional Bracket for Symbol(USER_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v2/leverageBracket",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<Brackets> getBracketsSymbol(String symbol);

	//User's Force Orders (USER_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v1/forceOrders",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.autoCloseType, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false}
	)
	public List<CoinmForceOrder> getUsersForceOrders(String symbol, AutoCloseTypes autoCloseType, Long startTime, Long endTime, Integer limit);

	default List<CoinmForceOrder> getUsersForceOrders(String symbol, AutoCloseTypes autoCloseType, Integer limit){
		return getUsersForceOrders(symbol, autoCloseType, null, null, limit);
	}
	
	//Position ADL Quantile Estimation (USER_DATA)
	@ApiEndpoint (
			endpoint = "/dapi/v1/adlQuantile",
			baseEndpoint = BaseEndpoints.FUTURE_COIN,
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

	//User Commission Rate (USER_DATA)
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
