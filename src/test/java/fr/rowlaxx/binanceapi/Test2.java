package fr.rowlaxx.binanceapi;

import java.io.IOException;
import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.core.market.BasicCandlestick;
import fr.rowlaxx.binanceapi.core.market.Intervals;
import fr.rowlaxx.binanceapi.core.order.NewOrderRequest;
import fr.rowlaxx.binanceapi.core.order.OrderResponseTypes;
import fr.rowlaxx.binanceapi.core.order.OrderSide;
import fr.rowlaxx.binanceapi.core.order.future.FutureOrderTypes;
import fr.rowlaxx.binanceapi.core.order.spot.SpotOrderRequest;

public class Test2 {
	
	public static void main(String[] args) throws IOException {
		
		final BinanceClient client = BinanceClient.create(Test.API_KEY, Test.API_SECRET);
		client.login();
		
		List<BasicCandlestick> a = client.spot().getCandlesticks("BTCUSDT", Intervals.HOUR_1);
	}

}
