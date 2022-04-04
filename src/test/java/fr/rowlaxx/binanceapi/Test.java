package fr.rowlaxx.binanceapi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import fr.rowlaxx.binanceapi.api.spot.SpotMarketDataStreamAPI.OnAggTrade;
import fr.rowlaxx.binanceapi.api.spot.SpotMarketDataStreamAPI.OnTrade;
import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.core.CompressedTrade;
import fr.rowlaxx.binanceapi.core.spot.stream.SpotStreamTrade;

public class Test {	

	private static BinanceClient client;

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, URISyntaxException {
		client = BinanceClient.create(args[0], args[1]);
		client.login();
		
		client.spot().stream().addOnAggTradeEvent(new OnAggTrade() {
			
			@Override
			public void onAggTrade(String symbol, CompressedTrade trade) {
				System.out.println(trade);
			}
		});
		
		client.spot().stream().subscribeAggTrade("btcusdt");
		
		
		Thread.sleep(20000);
		client.spot().stream().close();
		
	
	}


}
