package fr.rowlaxx.binanceapi.api.spot;

import fr.rowlaxx.binanceapi.api.Api;
import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.futuresalgo.VPOrderRequest;

/**
 * @version 2022-04-13
 * @author Théo
 * @see https://binance-docs.github.io/apidocs/spot/en/#futures
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
	
}
