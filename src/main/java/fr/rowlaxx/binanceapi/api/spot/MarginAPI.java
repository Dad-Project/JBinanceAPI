package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.margin.BNBBurnStatus;
import fr.rowlaxx.binanceapi.core.margin.CrossFeeData;
import fr.rowlaxx.binanceapi.core.margin.CrossMarginAccount;
import fr.rowlaxx.binanceapi.core.margin.CrossTransferRecord;
import fr.rowlaxx.binanceapi.core.margin.ForceLiquidationRecord;
import fr.rowlaxx.binanceapi.core.margin.InterestRecord;
import fr.rowlaxx.binanceapi.core.margin.IsolatedAccountLimit;
import fr.rowlaxx.binanceapi.core.margin.IsolatedFeeData;
import fr.rowlaxx.binanceapi.core.margin.IsolatedMarginAccount;
import fr.rowlaxx.binanceapi.core.margin.IsolatedMarginSymbol;
import fr.rowlaxx.binanceapi.core.margin.IsolatedMarginTransferRecord;
import fr.rowlaxx.binanceapi.core.margin.IsolatedTier;
import fr.rowlaxx.binanceapi.core.margin.LoanRecord;
import fr.rowlaxx.binanceapi.core.margin.MarginAsset;
import fr.rowlaxx.binanceapi.core.margin.MarginInterestRate;
import fr.rowlaxx.binanceapi.core.margin.MarginOCOOrder;
import fr.rowlaxx.binanceapi.core.margin.MarginOCOOrderRequest;
import fr.rowlaxx.binanceapi.core.margin.MarginOrder;
import fr.rowlaxx.binanceapi.core.margin.MarginOrderRequest;
import fr.rowlaxx.binanceapi.core.margin.MarginPair;
import fr.rowlaxx.binanceapi.core.margin.MarginTrade;
import fr.rowlaxx.binanceapi.core.margin.MaxBorrow;
import fr.rowlaxx.binanceapi.core.margin.PriceIndex;
import fr.rowlaxx.binanceapi.core.margin.RepayRecord;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.jsavon.annotations.MapKey;

/**
 * @version 2022-01-27
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#margin-account-trade
 */
public interface MarginAPI extends Api.Https, Api.Spot {

	//Cross Margin Account Transfer (MARGIN)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.amount, Parameters.type},
			mandatory = {true, true, true}
	)
	@RedirectResponse(path = "tranId")
	public long transferCross(String asset, double amount, int type);

	//Margin Account Borrow (MARGIN)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/loan",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isIsolated, Parameters.symbol, Parameters.amount},
			mandatory = {true, false, false, true}
	)
	@RedirectResponse(path = "tranId")
	public long borrow(String asset, Boolean isIsolated, String symbol, double amount);

	//Margin Account Repay (MARGIN)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/repay",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isIsolated, Parameters.symbol, Parameters.amount},
			mandatory = {true, false, false, true}
	)
	@RedirectResponse(path = "tranId")
	public long repay(String asset, Boolean isIsolated, String symbol, double amount);

	//Query Margin Asset (MARKET_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/asset",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.asset},
			mandatory = {true}
	)
	public MarginAsset getMarginAsset(String asset);

	//Query Cross Margin Pair (MARKET_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/pair",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public MarginPair getMarginPair(String symbol);

	//Get All Margin Assets (MARKET_DATA)
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

	//Get All Cross Margin Pairs (MARKET_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/allPairs",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, MarginPair> getAllMarginPairs();

	//Query Margin PriceIndex (MARKET_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/priceIndex",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = false,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public PriceIndex getPriceIndex(String symbol);

	//Margin Account New Order (TRADE)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.side, Parameters.type, Parameters.quantity, Parameters.quoteOrderQty, Parameters.price, Parameters.stopPrice, Parameters.newClientOrderId, Parameters.icebergQty, Parameters.newOrderRespType, Parameters.sideEffectType, Parameters.timeInForce},
			mandatory = {true, false, true, true, false, false, false, false, false, false, false, false, false}
	)
	public MarginOrder postOrder(MarginOrderRequest request);
	
	//Margin Account Cancel Order (TRADE)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.orderId, Parameters.origClientOrderId, Parameters.newClientOrderId},
			mandatory = {true, false, false, false, false}
	)
	public MarginOrder cancelOrder(String symbol, Boolean isIsolated, Long orderId, String origClientOrderId, String newClientOrderId);

	//Margin Account Cancel all Open Orders on a Symbol (TRADE)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/openOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated},
			mandatory = {true, false}
	)
	public List<MarginOrder> cancelAllOrders(String symbol, Boolean isIsolated);

	//Get Cross Margin Transfer History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.type, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.archived},
			mandatory = {false, false, false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<CrossTransferRecord> getMarginTransferHistory(String asset, String type, Long startTime, Long endTime, Long current, Long size, Boolean archived);

	//Query Loan Record (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/loan",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol, Parameters.txId, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.archived},
			mandatory = {true, false, false, false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<LoanRecord> getLoanHistory(String asset, String isolatedSymbol, Long txId, Long startTime, Long endTime, Long current, Long size, Boolean archived);

	//Query Repay Record (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/repay",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol, Parameters.txId, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.archived},
			mandatory = {true, false, false, false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<RepayRecord> getRepayHistory(String asset, String isolatedSymbol, Long txId, Long startTime, Long endTime, Long current, Long size, Boolean archived);

	//Get Interest History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/interestHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size, Parameters.archived},
			mandatory = {false, false, false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<InterestRecord> getInterestHistory(String asset, String isolatedSymbol, Long startTime, Long endTime, Long current, Long size, Boolean archived);

	//Get Force Liquidation Record (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/forceLiquidationRec",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.startTime, Parameters.endTime, Parameters.isolatedSymbol, Parameters.current, Parameters.size},
			mandatory = {false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<ForceLiquidationRecord> getForceLiquidationRecords(Long startTime, Long endTime, String isolatedSymbol, Long current, Long size);

	//Query Cross Margin Account Details (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public CrossMarginAccount getCrossMarginAccountDetails();

	//Query Margin Account's Order (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false, false}
	)
	public MarginOrder getOrder(String symbol, Boolean isIsolated, String orderId, String origClientOrderId);

	//Query Margin Account's Open Orders (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/openOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated},
			mandatory = {false, false}
	)
	public List<MarginOrder> getOpenOrders(String symbol, Boolean isIsolated);

	//Query Margin Account's All Orders (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/allOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false, false}
	)
	public List<MarginOrder> getAllOrders(String symbol, Boolean isIsolated, Long orderId, Long startTime, Long endTime, Integer limit);

	//Margin Account New OCO (TRADE)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/order/oco",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.listClientOrderId, Parameters.side, Parameters.quantity, Parameters.limitClientOrderId, Parameters.price, Parameters.limitIcebergQty, Parameters.stopClientOrderId, Parameters.stopPrice, Parameters.stopLimitPrice, Parameters.stopIcebergQty, Parameters.stopLimitTimeInForce, Parameters.newOrderRespType, Parameters.sideEffectType},
			mandatory = {true, false, false, true, true, false, true, false, false, true, false, false, false, false, false}
	)
	public MarginOCOOrder postOCOOrder(MarginOCOOrderRequest request);

	//Margin Account Cancel OCO (TRADE)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/orderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.orderListId, Parameters.listClientOrderId, Parameters.newClientOrderId},
			mandatory = {true, false, false, false, false}
	)
	public MarginOCOOrder cancelOCOOrder(String symbol, Boolean isIsolated, Long orderListId, String listClientOrderId, String newClientOrderId);

	//Query Margin Account's OCO (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/orderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.isIsolated, Parameters.symbol, Parameters.orderListId, Parameters.origClientOrderId},
			mandatory = {false, false, false, false}
	)
	public MarginOCOOrder getOCOOrder(Boolean isIsolated, String symbol, Long orderListId, String origClientOrderId);

	//Query Margin Account's all OCO (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/allOrderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.isIsolated, Parameters.symbol, Parameters.fromId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false, false, false}
	)
	public List<MarginOCOOrder> getAllOCOOrders(Boolean isIsolated, String symbol, Long fromId, Long startTime, Long endTime, Integer limit);

	//Query Margin Account's Open OCO (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/openOrderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.isIsolated, Parameters.symbol},
			mandatory = {false, false}
	)
	public List<MarginOCOOrder> getOpenOCOOrders(Boolean isIsolated, String symbol);

	//Query Margin Account's Trade List (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/myTrades",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.isIsolated, Parameters.startTime, Parameters.endTime, Parameters.fromId, Parameters.limit},
			mandatory = {true, false, false, false, false, false}
	)
	public List<MarginTrade> getTrades(String symbol, Boolean isIsolated, Long startTime, Long endTime, Long fromId, Integer limit);

	//Query Max Borrow (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/maxBorrowable",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol},
			mandatory = {true, false}
	)
	public MaxBorrow getMaxBorrow(String asset, String isolatedSymbol);

	//Query Max Transfer-Out Amount (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/maxTransferable",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.isolatedSymbol},
			mandatory = {true, false}
	)
	@RedirectResponse(path = "amount")
	public double getMaxTransferOutAmount(String asset, String isolatedSymbol);

	//Isolated Margin Account Transfer (MARGIN)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.symbol, Parameters.transFrom, Parameters.transTo, Parameters.amount},
			mandatory = {true, true, true, true, true}
	)
	@RedirectResponse(path = "tranId")
	public long transferIsolated(String asset, String symbol, String transFrom, String transTo, double amount);

	//Get Isolated Margin Transfer History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/transfer",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.symbol, Parameters.transFrom, Parameters.transTo, Parameters.startTime, Parameters.endTime, Parameters.current, Parameters.size},
			mandatory = {false, true, false, false, false, false, false, false}
	)
	@RedirectResponse(path = "rows")
	public List<IsolatedMarginTransferRecord> getIsolatedTransferHistory(String asset, String symbol, String transFrom, String transTo, Long startTime, Long endTime, Long current, Long size);

	//Query Isolated Margin Account Info (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbols},
			mandatory = {true}
	)
	@RedirectResponse(path = "assets")
	public IsolatedMarginAccount getIsolatedMarginAccountDetails(String symbols);

	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public IsolatedMarginAccount getIsolatedMarginAccountDetails();

	//Disable Isolated Margin Account (TRADE)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	@RedirectResponse(path = "success")
	public boolean disableIsolatedMargin(String symbol);

	//Enable Isolated Margin Account (TRADE)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	@RedirectResponse(path = "success")
	public boolean enableIsolatedMargin(String symbol);

	//Query Enabled Isolated Margin Account Limit (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/accountLimit",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public IsolatedAccountLimit getIsolatedAccountLimit();

	//Query Isolated Margin Symbol (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/pair",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public IsolatedMarginSymbol getIsolatedSymbol(String symbol);

	//Get All Isolated Margin Symbol(USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolated/allPairs",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "symbol")
	public Map<String, IsolatedMarginSymbol> getAllIsolatedMarginSymbol();

	//Toggle BNB Burn On Spot Trade And Margin Interest (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/bnbBurn",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.spotBNBBurn, Parameters.interestBNBBurn},
			mandatory = {false, false}
	)
	public BNBBurnStatus setBNBBurnStatus(Boolean spotBNBBurn, Boolean interestBNBBurn);

	//Get BNB Burn Status (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/bnbBurn",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public BNBBurnStatus getBNBBurnStatus();

	//Query Margin Interest Rate History (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/interestRateHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.asset, Parameters.vipLevel, Parameters.startTime, Parameters.endTime},
			mandatory = {true, false, false, false, false}
	)
	public List<MarginInterestRate> getInterestRateHistory(String asset, Integer vipLevel, Long startTime, Long endTime);

	//Query Cross Margin Fee Data (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/crossMarginData",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.vipLevel, Parameters.coin},
			mandatory = {false, false}
	)
	public List<CrossFeeData> getCrossFeeHistory(String asset, Integer vipLevel, Long startTime, Long endTime, Integer limit);

	//Query Isolated Margin Fee Data (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolatedMarginData",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.vipLevel, Parameters.coin},
			mandatory = {false, false}
	)
	public List<IsolatedFeeData> getIsolatedFeeHistory(String asset, Integer vipLevel, Long startTime, Long endTime, Integer limit);
	
	//Query Isolated Margin Tier Data (USER_DATA)
	@ApiEndpoint (
			endpoint = "/sapi/v1/margin/isolatedMarginTier",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.tier},
			mandatory = {true, false}
	)
	public List<IsolatedTier> getIsolatedTierHistory(String asset, Integer vipLevel, Long startTime, Long endTime, Integer limit);
}