package fr.rowlaxx.binanceapi.interfaces.api;

import java.util.List;

import fr.rowlaxx.binanceapi.client.http.ApiEndpoint;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.RedirectResponse;
import fr.rowlaxx.binanceapi.core.order.OrderSide;
import fr.rowlaxx.binanceapi.core.order.c2c.C2CTrade;

public interface C2CAPI {

	@ApiEndpoint (
			endpoint = "/sapi/v1/c2c/orderMatch/listUserOrderHistory",
			baseEndpoint = BaseEndpoints.SPOT,
			method = Method.GET,
			needSignature = true,
			parameters = {Parameters.tradeType, Parameters.startTimestamp, Parameters.endTimestamp, Parameters.page, Parameters.rows},
			mandatory = {true, false, false, false, false}
	)
	@RedirectResponse(path = "data")
	public List<C2CTrade> getGetC2CTradeHistory(OrderSide tradeType, Long startTimestamp, Long endTimestamp, Integer page, Integer rows);
}