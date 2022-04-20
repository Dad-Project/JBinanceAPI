package fr.rowlaxx.binanceapi.api.spot;

import java.util.List;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.OrderSides;
import fr.rowlaxx.binanceapi.core.futuresalgo.VPOrder;
import fr.rowlaxx.binanceapi.core.futuresalgo.VPOrderRequest;
import fr.rowlaxx.binanceapi.core.futuresalgo.VPSubOrder;

/**
 * @version 2022-04-13
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#futures-algo-endpoints
 */
public interface FuturesAlgoAPI extends Api.Https, Api.Spot {

	//Volume Participation(VP) New Order (TRADE)
	@ApiEndpoint(
			needSignature = true,
			baseEndpoint = BaseEndpoints.SPOT,
			endpoint = "sapi/v1/algo/futures/newOrderVp",
			method = Method.POST,
			parameters = {Parameters.symbol, Parameters.side, Parameters.positionSide, Parameters.quantity, Parameters.urgency, Parameters.clientAlgoId, Parameters.reduceOnly, Parameters.limitPrice},
			mandatory = {true, true, false, true, true, false, false, false}			
	)
	@RedirectResponse(path = "clientAlgoId")
	public String postOrder(VPOrderRequest request);
	
	//Cancel Algo Order (TRADE)
	@ApiEndpoint(
			needSignature = true,
			baseEndpoint = BaseEndpoints.SPOT,
			endpoint = "sapi/v1/algo/futures/order",
			method = Method.DELETE,
			parameters = {Parameters.algoId},
			mandatory = {true}
	)
	public String cancelOrder(String algoId);
	
	//Query Current Algo Open Orders (USER_DATA)
	@ApiEndpoint(
			needSignature = true,
			baseEndpoint = BaseEndpoints.SPOT,
			endpoint = "sapi/v1/algo/futures/openOrders",
			method = Method.GET,
			parameters = {},
			mandatory = {}
	)
	@RedirectResponse(path = "orders")
	public List<VPOrder> getOpenOrders();
	
	//Query Historical Algo Orders (USER_DATA)
	@ApiEndpoint(
			needSignature = true,
			baseEndpoint = BaseEndpoints.SPOT,
			endpoint = "sapi/v1/algo/futures/historicalOrders",
			method = Method.GET,
			parameters = {Parameters.symbol, Parameters.side, Parameters.startTime, Parameters.endTime, Parameters.page, Parameters.pageSize},
			mandatory = {false, false, false, false, false, false}
	)
	@RedirectResponse(path = "orders")
	public List<VPOrder> getOrders(String symbol, OrderSides side, Long startTime, Long endTime, Integer page, Integer pageSize);
	
	default List<VPOrder> getOrders(String symbol, OrderSides side, Integer page, Integer pageSize){
		return getOrders(symbol, side, null, null, page, pageSize);
	}
	
	//Query Sub Orders (USER_DATA)
	@ApiEndpoint(
			needSignature = true,
			baseEndpoint = BaseEndpoints.SPOT,
			endpoint = " sapi/v1/algo/futures/subOrders",
			method = Method.GET,
			parameters = {Parameters.algoId, Parameters.page, Parameters.pageSize},
			mandatory = {true, false, false}
	)
	@RedirectResponse(path = "orders")
	public List<VPSubOrder> getSubOrders(String algoId, Integer page, Integer pageSize);
	
}
