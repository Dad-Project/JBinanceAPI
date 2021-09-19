package fr.rowlaxx.binanceapi.interfaces.api.spot;

import java.util.List;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.core.order.spot.SpotOCOOrder;
import fr.rowlaxx.binanceapi.core.order.spot.SpotOCOOrderRequest;
import fr.rowlaxx.binanceapi.core.order.spot.SpotOrder;
import fr.rowlaxx.binanceapi.core.order.spot.SpotOrderRequest;
import fr.rowlaxx.binanceapi.core.spot.SpotAccountInformation;
import fr.rowlaxx.binanceapi.core.spot.SpotAccountTrade;

public interface SpotTradeAPI {

	@ApiEndpoint (
			endpoint = "/api/v3/order/test",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = false,
			parameters = {Parameters.symbol, Parameters.side, Parameters.type, Parameters.timeInForce, Parameters.quantity, Parameters.quoteOrderQty, Parameters.price, Parameters.newClientOrderId, Parameters.stopPrice, Parameters.icebergQty, Parameters.newOrderRespType},
			mandatory = {true, true, true, false, false, false, false, false, false, false, false}
	)
	public SpotOrder postTestOrder(SpotOrderRequest orderRequest);

	@ApiEndpoint (
			endpoint = "/api/v3/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.side, Parameters.type, Parameters.timeInForce, Parameters.quantity, Parameters.quoteOrderQty, Parameters.price, Parameters.newClientOrderId, Parameters.stopPrice, Parameters.icebergQty, Parameters.newOrderRespType},
			mandatory = {true, true, true, false, false, false, false, false, false, false, false}
	)
	public SpotOrder postOrder(SpotOrderRequest orderRequest);

	@ApiEndpoint (
			endpoint = "/api/v3/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId, Parameters.newClientOrderId},
			mandatory = {true, false, false, false}
	)
	public SpotOrder cancelOrder(String symbol, Long orderId, String origClientOrderId, String newClientOrderId);

	@ApiEndpoint (
			endpoint = "api/v3/openOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {true}
	)
	public List<SpotOrder> cancelAllOpenOrders(String symbol);

	@ApiEndpoint (
			endpoint = "/api/v3/order",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.origClientOrderId},
			mandatory = {true, false, false}
	)
	public SpotOrder getOrder(String symbol, Long orderId, String origClientOrderId);

	@ApiEndpoint (
			endpoint = "/api/v3/openOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol},
			mandatory = {false}
	)
	public List<SpotOrder> getOpenOrders(String symbol);

	@ApiEndpoint (
			endpoint = "/api/v3/allOrders",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {true, false, false, false, false}
	)
	public List<SpotOrder> getAllOrders(String symbol, Long orderId, Long startTime, Long endTime, Integer limit);

	@ApiEndpoint (
			endpoint = "/api/v3/order/oco",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.POST,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.listClientOrderId, Parameters.side, Parameters.quantity, Parameters.limitClientOrderId, Parameters.price, Parameters.limitIcebergQty, Parameters.stopClientOrderId, Parameters.stopPrice, Parameters.stopLimitPrice, Parameters.stopIcebergQty, Parameters.stopLimitTimeInForce, Parameters.newOrderRespType},
			mandatory = {true, false, true, true, false, true, false, false, true, false, false, false, false}
	)
	public SpotOCOOrder postOCOOrder(SpotOCOOrderRequest request);

	@ApiEndpoint (
			endpoint = "/api/v3/orderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.DELETE,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderListId, Parameters.listClientOrderId, Parameters.newClientOrderId},
			mandatory = {true, false, false, false}
	)
	public SpotOCOOrder cancelOCOOrder(String symbol, Long orderListId, String listClientOrderId, String newClientOrderId);

	@ApiEndpoint (
			endpoint = "/api/v3/orderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.orderListId, Parameters.origClientOrderId},
			mandatory = {false, false}
	)
	public SpotOCOOrder getOCOOrder(Long orderListId, String origClientOrderId);

	@ApiEndpoint (
			endpoint = "/api/v3/allOrderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.fromId, Parameters.startTime, Parameters.endTime, Parameters.limit},
			mandatory = {false, false, false, false}
	)
	public List<SpotOCOOrder> getAllOCOOrder(Long fromId, Long startTime, Long endTime, Integer limit);

	@ApiEndpoint (
			endpoint = "/api/v3/openOrderList",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public List<SpotOCOOrder> getOpenOCOOrders();

	@ApiEndpoint (
			endpoint = "/api/v3/account",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {},
			mandatory = {}
	)
	public SpotAccountInformation getAccountInformation();

	@ApiEndpoint (
			endpoint = "/api/v3/myTrades",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.symbol, Parameters.orderId, Parameters.startTime, Parameters.endTime, Parameters.fromId, Parameters.limit},
			mandatory = {true, false, false, false, false, false}
	)
	public List<SpotAccountTrade> getAccountTradeList(String symbol, Long orderId, Long startTime, Long endTime, Long fromId, Integer limit);
}