package fr.rowlaxx.binanceapi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.core.spot.stream.SpotStreamTrade;

public class Test {	

	private static BinanceClient client;

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, URISyntaxException {
		client = BinanceClient.create(args[0], args[1]);
		client.login();
		
		
		client.spot().stream().addOnTradeEvent( (String symbol, SpotStreamTrade trade) -> System.out.println(trade) );
		
		client.spot().stream().subscribeTrade("btcusdt");
		
	}


}
