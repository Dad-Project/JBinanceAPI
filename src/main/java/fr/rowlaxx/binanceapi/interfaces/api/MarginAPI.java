package fr.rowlaxx.binanceapi.interfaces.api;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.general.margin.CrossMarginPair;
import fr.rowlaxx.binanceapi.core.general.margin.MarginAsset;
import fr.rowlaxx.binanceapi.core.market.margin.MarginPriceIndex;
import fr.rowlaxx.jsavon.annotations.MapKey;

public interface MarginAPI {

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.amount, Parameters.type},
			mandatory = {true, true, true}
	)
	@RedirectResponse(path = "tranId")
	public long crossMarginAccountTransfer(String asset, double amount, int type);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/loan",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isIsolated, Parameters.symbol, Parameters.amount},
			mandatory = {true, false, false, true}
	)
	@RedirectResponse(path = "tranId")
	public long marginAccountBorrow(String asset, Boolean isIsolated, String symbol, double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/repay",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isIsolated, Parameters.symbol, Parameters.amount},
			mandatory = {true, false, false, true}
	)
	@RedirectResponse(path = "tranId")
	public long marginAccountRepay(String asset, Boolean isIsolated, String symbol, double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/asset",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.asset},
			mandatory = {true}
	)
	public MarginAsset getMarginAsset(String asset);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/pair",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public CrossMarginPair getCrossMarginPair(String symbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/allAssets",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "assetName")
	public Map<String, MarginAsset> getMarginAssets();

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/allPairs",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, CrossMarginPair> getGetAllCrossMarginPairs();

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/priceIndex",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public MarginPriceIndex getMarginPriceIndex(String symbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.side, Parameters.type, Parameters.quantity, Parameters.quoteOrderQty, Parameters.price, Parameters.stopPrice, Parameters.newClientOrderId, Parameters.icebergQty, Parameters.newOrderRespType, Parameters.sideEffectType, Parameters.timeInForce},
			mandatory = {true, false, true, true, false, false, false, false, false, false, false, false, false}
	)
	public MarginAccountNewOrder postMarginAccountNewOrder(String symbol, String isIsolated, Enum side, Enum type, double quantity, double quoteOrderQty, double price, double stopPrice, String newClientOrderId, double icebergQty, Enum newOrderRespType, Enum sideEffectType, Enum timeInForce);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.side, Parameters.type, Parameters.quantity, Parameters.quoteOrderQty, Parameters.price, Parameters.stopPrice, Parameters.newClientOrderId, Parameters.icebergQty, Parameters.newOrderRespType, Parameters.sideEffectType, Parameters.timeInForce},
			mandatory = {true, false, true, true, false, false, false, false, false, false, false, false, false}
	)
	public MarginAccountNewOrder1 postMarginAccountNewOrder1(String symbol, String isIsolated, Enum side, Enum type, double quantity, double quoteOrderQty, double price, double stopPrice, String newClientOrderId, double icebergQty, Enum newOrderRespType, Enum sideEffectType, Enum timeInForce);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.side, Parameters.type, Parameters.quantity, Parameters.quoteOrderQty, Parameters.price, Parameters.stopPrice, Parameters.newClientOrderId, Parameters.icebergQty, Parameters.newOrderRespType, Parameters.sideEffectType, Parameters.timeInForce},
			mandatory = {true, false, true, true, false, false, false, false, false, false, false, false, false}
	)
	public MarginAccountNewOrder2 postMarginAccountNewOrder2(String symbol, String isIsolated, Enum side, Enum type, double quantity, double quoteOrderQty, double price, double stopPrice, String newClientOrderId, double icebergQty, Enum newOrderRespType, Enum sideEffectType, Enum timeInForce);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.orderId, Parameters.origClientOrderId, Parameters.newClientOrderId},
			mandatory = {true, false, false, false, false}
	)
	public MarginAccountCancelOrder deleteMarginAccountCancelOrder(String symbol, String isIsolated, long orderId, String origClientOrderId, String newClientOrderId);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/openOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated},
			mandatory = {true, false}
	)
	public List<MarginAccountCancelallOpenOrdersonaSymbol> deleteMarginAccountCancelallOpenOrdersonaSymbol(String symbol, String isIsolated);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.archived},
			mandatory = {false, false, false, false, false, false, false}
	)
	public GetCrossMarginTransferHistory getGetCrossMarginTransferHistory(String asset, String type, long startTime, long endTime, long current, long size, String archived);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/loan",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol, Parameters.txId, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.archived},
			mandatory = {true, false, false, false, false, false, false, false}
	)
	public QueryLoanRecord getQueryLoanRecord(String asset, String isolatedSymbol, long txId, long startTime, long endTime, long current, long size, String archived);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/repay",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol, Parameters.txId, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.archived},
			mandatory = {true, false, false, false, false, false, false, false}
	)
	public QueryRepayRecord getQueryRepayRecord(String asset, String isolatedSymbol, long txId, long startTime, long endTime, long current, long size, String archived);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/interestHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.archived},
			mandatory = {false, false, false, false, false, false, false}
	)
	public GetInterestHistory getGetInterestHistory(String asset, String isolatedSymbol, long startTime, long endTime, long current, long size, String archived);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/forceLiquidationRec",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.startTime, Parameters.endTime, Parameters.isolatedSymbol, Parameters.current, Parameters.size},
			mandatory = {false, false, false, false, false}
	)
	public GetForceLiquidationRecord getGetForceLiquidationRecord(long startTime, long endTime, String isolatedSymbol, long current, long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public QueryCrossMarginAccountDetails getQueryCrossMarginAccountDetails();

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false, false}
	)
	public QueryMarginAccountsOrder getQueryMarginAccountsOrder(String symbol, String isIsolated, String orderId, String origClientOrderId);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/openOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated},
			mandatory = {false, false}
	)
	public List<QueryMarginAccountsOpenOrders> getQueryMarginAccountsOpenOrders(String symbol, String isIsolated);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/allOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false, false}
	)
	public List<QueryMarginAccountsAllOrders> getQueryMarginAccountsAllOrders(String symbol, String isIsolated, long orderId, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/order/oco",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.listClientOrderId, Parameters.side, Parameters.quantity, Parameters.limitClientOrderId, Parameters.price, Parameters.limitIcebergQty, Parameters.stopClientOrderId, Parameters.stopPrice, Parameters.stopLimitPrice, Parameters.stopIcebergQty, Parameters.stopLimitTimeInForce, Parameters.newOrderRespType, Parameters.sideEffectType},
			mandatory = {true, false, false, true, true, false, true, false, false, true, false, false, false, false, false}
	)
	public MarginAccountNewOCO postMarginAccountNewOCO(String symbol, String isIsolated, String listClientOrderId, Enum side, double quantity, String limitClientOrderId, double price, double limitIcebergQty, String stopClientOrderId, double stopPrice, double stopLimitPrice, double stopIcebergQty, Enum stopLimitTimeInForce, Enum newOrderRespType, Enum sideEffectType);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/orderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.orderListId, Parameters.listClientOrderId, Parameters.newClientOrderId},
			mandatory = {true, false, false, false, false}
	)
	public MarginAccountCancelOCO deleteMarginAccountCancelOCO(String symbol, String isIsolated, long orderListId, String listClientOrderId, String newClientOrderId);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/orderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.isIsolated, Parameters.symbol, Parameters.orderListId, Parameters.origClientOrderId},
			mandatory = {false, false, false, false}
	)
	public QueryMarginAccountsOCO getQueryMarginAccountsOCO(String isIsolated, String symbol, long orderListId, String origClientOrderId);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/allOrderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.isIsolated, Parameters.symbol, Parameters.fromId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<QueryMarginAccountsallOCO> getQueryMarginAccountsallOCO(String isIsolated, String symbol, long fromId, long startTime, long endTime, int limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/openOrderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.isIsolated, Parameters.symbol},
			mandatory = {false, false}
	)
	public List<QueryMarginAccountsOpenOCO> getQueryMarginAccountsOpenOCO(String isIsolated, String symbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/myTrades",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.startTime, Parameters.endTime, Parameters.fromId, Parameters.limit},
			mandatory = {true, false, false, false, false, false}
	)
	public List<QueryMarginAccountsTradeList> getQueryMarginAccountsTradeList(String symbol, String isIsolated, long startTime, long endTime, long fromId, int limit);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/maxBorrowable",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol},
			mandatory = {true, false}
	)
	public QueryMaxBorrow getQueryMaxBorrow(String asset, String isolatedSymbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/maxTransferable",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol},
			mandatory = {true, false}
	)
	public QueryMaxTransferOutAmount getQueryMaxTransferOutAmount(String asset, String isolatedSymbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.symbol, Parameters.transFrom, Parameters.transTo, Parameters.amount},
			mandatory = {true, true, true, true, true}
	)
	public IsolatedMarginAccountTransfer postIsolatedMarginAccountTransfer(String asset, String symbol, String transFrom, String transTo, double amount);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.symbol, Parameters.transFrom, Parameters.transTo, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {false, true, false, false, false, false, false, false}
	)
	public GetIsolatedMarginTransferHistory getGetIsolatedMarginTransferHistory(String asset, String symbol, String transFrom, String transTo, long startTime, long endTime, long current, long size);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbols},
			mandatory = {false}
	)
	public QueryIsolatedMarginAccountInfo getQueryIsolatedMarginAccountInfo(String symbols);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbols},
			mandatory = {false}
	)
	public QueryIsolatedMarginAccountInfo1 getQueryIsolatedMarginAccountInfo1(String symbols);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public DisableIsolatedMarginAccount deleteDisableIsolatedMarginAccount(String symbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public EnableIsolatedMarginAccount postEnableIsolatedMarginAccount(String symbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/accountLimit",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public QueryEnabledIsolatedMarginAccountLimit getQueryEnabledIsolatedMarginAccountLimit();

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/pair",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public QueryIsolatedMarginSymbol getQueryIsolatedMarginSymbol(String symbol);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/allPairs",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public List<GetAllIsolatedMarginSymbol> getGetAllIsolatedMarginSymbol();

	@ApiEndpoint (
			endpoint = "/sapi/v1/bnbBurn",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.spotBNBBurn, Parameters.interestBNBBurn},
			mandatory = {false, false}
	)
	public ToggleBNBBurnOnSpotTradeAndMarginInterest postToggleBNBBurnOnSpotTradeAndMarginInterest(String spotBNBBurn, String interestBNBBurn);

	@ApiEndpoint (
			endpoint = "/sapi/v1/bnbBurn",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public GetBNBBurnStatus getGetBNBBurnStatus();

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/interestRateHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.vipLevel, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<QueryMarginInterestRateHistory> getQueryMarginInterestRateHistory(String asset, int vipLevel, long startTime, long endTime, int limit);
}