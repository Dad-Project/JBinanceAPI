package fr.rowlaxx.binanceapi.interfaces.api.spot;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.core.api.spot.SpotOrderTypes;
import fr.rowlaxx.binanceapi.core.trade.OrderResponseType;
import fr.rowlaxx.binanceapi.core.trade.OrderSide;
import fr.rowlaxx.binanceapi.core.trade.OrderType;
import fr.rowlaxx.binanceapi.core.trade.TimeInForce;

public interface SpotAccountAPI {
	
	@ApiEndpoint(
			endpoint = "/api/v3/order", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {Parameters.symbol, Parameters.side, Parameters.type, Parameters.timeInForce, Parameters.quantity, Parameters.quoteOrderQty, Parameters.price, Parameters.newClientOrderId, Parameters.stopPrice, Parameters.icebergQty, Parameters.newOrderRespType},
			mandatory = {true, true, true, false, false, false, false, false, false, false, false}
	)
	public undone newOrder(String symbol, OrderSide side, SpotOrderTypes type, TimeInForce timeInForce, Double quantity, Double quoteOrderQty, Double price, String newClientOrderId, Double stopPrice, Double icebergQty, OrderResponseType newOrderRespType);
	
	
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 
	
	@ApiEndpoint(
			endpoint = "/api/v3", 
			baseEndpoint = ApiEndpoint.SPOT_BASE_ENDPOINT, 
			method = Method.POST, 
			needSignature = true, 
			parameters = {},
			mandatory = {}
	)
	public undone 

}
