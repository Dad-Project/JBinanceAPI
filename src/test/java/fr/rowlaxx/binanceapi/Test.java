package fr.rowlaxx.binanceapi;

import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.core.BasicCandlestick;
import fr.rowlaxx.binanceapi.core.Intervals;

public class Test {

	private final static BinanceClient client = Secret.client;
	
	
	public static void main(String[] args) {
		
		for (BasicCandlestick c : client.usdm().market().getCandlesticks("BTCUSDT", Intervals.MINUTE_15, 10))
				System.out.println(c);
	}

}
