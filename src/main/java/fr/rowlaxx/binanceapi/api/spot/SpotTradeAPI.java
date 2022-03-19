package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;
import java.util.Map;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.exchangeinfos.RateLimitIntervals;
import fr.rowlaxx.binanceapi.core.spot.trade.AccountInformation;
import fr.rowlaxx.binanceapi.core.spot.trade.OrderLimit;
import fr.rowlaxx.binanceapi.core.spot.trade.SpotAccountTrade;
import fr.rowlaxx.binanceapi.core.spot.trade.SpotOCOOrder;
import fr.rowlaxx.binanceapi.core.spot.trade.SpotOCOOrderRequest;
import fr.rowlaxx.binanceapi.core.spot.trade.SpotOrder;
import fr.rowlaxx.binanceapi.core.spot.trade.SpotOrderRequest;
import fr.rowlaxx.convertutils.MapKey;
import fr.rowlaxx.binanceapi.client.http.Parameters;

/**
 * @version 2022-01-27
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#spot-account-trade
 */
public interface SpotTradeAPI extends Api.Https, Api.Spot {

	//Test New Order (TRADE)
	@ApiEndpoint (
			endpoint = "/api/v3/order/test",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.side, Parameters.type, Parameters.timeInForce, Parameters.quantity, Parameters.quoteOrderQty, Parameters.price, Parameters.newClientOrderId, Parameters.stopPrice, Parameters.icebergQty, Parameters.newOrderRespType},
			mandatory = {true, true, true, false, false, false, false, false, false, false, false}
	)
	public SpotOrder postTestOrder(SpotOrderRequest orderRequest);

	//New Order (TRADE)
	@ApiEndpoint (
			endpoint = "/api/v3/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.side, Parameters.type, Parameters.timeInForce, Parameters.quantity, Parameters.quoteOrderQty, Parameters.price, Parameters.newClientOrderId, Parameters.stopPrice, Parameters.icebergQty, Parameters.newOrderRespType},
			mandatory = {true, true, true, false, false, false, false, false, false, false, false}
	)
	public SpotOrder postOrder(SpotOrderRequest orderRequest);

	//Cancel Order (TRADE)
	@ApiEndpoint (
			endpoint = "/api/v3/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId, Parameters.newClientOrderId},
			mandatory = {true, false, false, false}
	)
	public SpotOrder cancelOrder(String symbol, Long orderId, String origClientOrderId, String newClientOrderId);

	//Cancel all Open Orders on a Symbol (TRADE)
	@ApiEndpoint (
			endpoint = "api/v3/openOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public List<SpotOrder> cancelAllOpenOrders(String symbol);

	//Query Order (USER_DATA)
	@ApiEndpoint (
			endpoint = "/api/v3/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false}
	)
	public SpotOrder getOrder(String symbol, Long orderId, String origClientOrderId);

	//Current Open Orders (USER_DATA)
	@ApiEndpoint (
			endpoint = "/api/v3/openOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<SpotOrder> getOpenOrders(String symbol);

	default List<SpotOrder> getAllOpenOrders(){
		return getOpenOrders(null);
	}
	
	//All Orders (USER_DATA)
	@ApiEndpoint (
			endpoint = "/api/v3/allOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<SpotOrder> getAllOrders(String symbol, Long orderId, Long startTime, Long endTime, Integer limit);

	//New OCO (TRADE)
	@ApiEndpoint (
			endpoint = "/api/v3/order/oco",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.listClientOrderId, Parameters.side, Parameters.quantity, Parameters.limitClientOrderId, Parameters.price, Parameters.limitIcebergQty, Parameters.stopClientOrderId, Parameters.stopPrice, Parameters.stopLimitPrice, Parameters.stopIcebergQty, Parameters.stopLimitTimeInForce, Parameters.newOrderRespType},
			mandatory = {true, false, true, true, false, true, false, false, true, false, false, false, false}
	)
	public SpotOCOOrder postOrder(SpotOCOOrderRequest request);

	//Cancel OCO (TRADE)
	@ApiEndpoint (
			endpoint = "/api/v3/orderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderListId, Parameters.listClientOrderId, Parameters.newClientOrderId},
			mandatory = {true, false, false, false}
	)
	public SpotOCOOrder cancelOCOOrder(String symbol, Long orderListId, String listClientOrderId, String newClientOrderId);

	//Query OCO (USER_DATA)
	@ApiEndpoint (
			endpoint = "/api/v3/orderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.orderListId, Parameters.origClientOrderId},
			mandatory = {false, false}
	)
	public SpotOCOOrder getOCOOrder(Long orderListId, String origClientOrderId);

	//Query all OCO (USER_DATA)
	@ApiEndpoint (
			endpoint = "/api/v3/allOrderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.fromId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false}
	)
	public List<SpotOCOOrder> getAllOCOOrder(Long fromId, Long startTime, Long endTime, Integer limit);

	//Query Open OCO (USER_DATA)
	@ApiEndpoint (
			endpoint = "/api/v3/openOrderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public List<SpotOCOOrder> getOpenOCOOrders();

	//Account Information (USER_DATA)
	@ApiEndpoint (
			endpoint = "/api/v3/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public AccountInformation getAccountInformation();

	//Account Trade List (USER_DATA)
	@ApiEndpoint (
			endpoint = "/api/v3/myTrades",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.fromId, Parameters.limit},
			mandatory = {true, false, false, false, false, false}
	)
	public List<SpotAccountTrade> getAccountTradeList(String symbol, Long orderId, Long startTime, Long endTime, Long fromId, Integer limit);

	//Query Current Order Count Usage (TRADE)
	@ApiEndpoint (
			endpoint = "/api/v3/rateLimit/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	@MapKey(fieldName = "interval")
	public Map<RateLimitIntervals, OrderLimit> getCurrentOrderLimitState();

}