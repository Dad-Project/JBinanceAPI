package fr.rowlaxx.binanceapi;

import java.io.IOException;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.order.OrderResponseTypes;
import fr.rowlaxx.binanceapi.core.order.OrderSide;
import fr.rowlaxx.binanceapi.core.order.future.FutureOrderTypes;

public class Test2 {
	
	public static void main(String[] args) throws IOException {
		
		final BinanceClient client = BinanceClient.create(Test.API_KEY, Test.API_SECRET);
		client.login();
		
		final BinanceHttpRequest request = BinanceHttpRequest.newBuilder()
				.setBaseEndpoint(BaseEndpoints.FUTURE_USD)
				.setEndpoint("/fapi/v1/order")
				.addSignature(true)
				.setMethod(Method.POST)
				.addParameter(Parameters.symbol, "COTIUSDT")
				.addParameter(Parameters.side, OrderSide.SELL)
				.addParameter(Parameters.type, FutureOrderTypes.MARKET)
				.addParameter(Parameters.newOrderRespType, OrderResponseTypes.ACK)
				.addParameter(Parameters.quantity, 12.0)
				.build();
		
		final JSONObject response = client.getHttpClient().execute(request);
		System.out.println(response.toString(2));
	}

}
