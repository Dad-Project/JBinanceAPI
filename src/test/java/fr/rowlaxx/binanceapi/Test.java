package fr.rowlaxx.binanceapi;

import java.util.List;

import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.core.spot.marketdata.SpotExchangeInformation;
import fr.rowlaxx.binanceapi.core.spot.marketdata.SpotTrade;

public class Test {

	private final static BinanceClient client = Secret.client;
	
	
	public static void main(String[] args) {
		
		List<SpotTrade> t = client.spot().market().getRecentTrades("BTCUSDT", 100);
		for (SpotTrade trade : t)
			System.out.println(trade);
		
	}

}
