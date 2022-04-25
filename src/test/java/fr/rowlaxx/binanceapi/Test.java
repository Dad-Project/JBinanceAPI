package fr.rowlaxx.binanceapi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import fr.rowlaxx.binanceapi.api.spot.SpotMarketStreamAPI.OnTrade;
import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.core.spot.marketstream.SpotStreamTrade;

public class Test {	

	private static BinanceClient client;

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, URISyntaxException {
		client = BinanceClient.create(args[0], args[1]);
		client.login();
		
		client.spot().marketstream().subscribeTicker("btcusdt");
		client.spot().marketstream().addOnTradeEvent(new OnTrade() {
			
			@Override
			public void onTrade(String symbol, SpotStreamTrade trade) {
				System.out.println(trade);
			}
		});
	}


}
