package fr.rowlaxx.binanceapi;

import java.util.List;

import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.core.BasicCandlestick;
import fr.rowlaxx.binanceapi.core.Intervals;

public class Test {

	private static BinanceClient client = BinanceClient.create(Secret.API_KEY, Secret.API_SECRET);
	
	public static void main(String[] args) {
		
		List<BasicCandlestick> candles = client.spot().market().getCandlesticks("BTCUSDT", Intervals.DAY_1, 10);
		for (BasicCandlestick candle : candles)
			System.out.println(candle);
		
	}

}
