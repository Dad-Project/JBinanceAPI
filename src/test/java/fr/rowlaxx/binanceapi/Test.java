package fr.rowlaxx.binanceapi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;

import fr.rowlaxx.binanceapi.api.spot.BLVTStreamAPI.OnInfo;
import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.core.Intervals;
import fr.rowlaxx.binanceapi.core.blvt.BlvtCandlestick;
import fr.rowlaxx.binanceapi.core.blvt.BlvtInfoStream;
import fr.rowlaxx.binanceapi.core.spot.stream.SpotStreamTrade;

public class Test {	

	private static BinanceClient client;

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, URISyntaxException {
		client = BinanceClient.create(args[0], args[1]);
		client.login();
		
		
		client.blvt().stream().subscribeInfo("btcup");
		client.blvt().stream().addOnInfoEvent(new OnInfo() {
			
			@Override
			public void onInfo(String symbol, BlvtInfoStream info) {
				System.out.println(info);
			}
		});
		Thread.sleep(10000);
		client.blvt().stream().close();
	}


}
