package fr.rowlaxx.binanceapi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;

import fr.rowlaxx.binanceapi.api.spot.SpotUserStreamAPI.OnAccountUpdate;
import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.core.Asset;

public class Test {	

	private static BinanceClient client;

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException, URISyntaxException {
		client = BinanceClient.create(args[0], args[1]);
		
		client.spot().userstream().addOnAccountUpdateEvent(new OnAccountUpdate() {
			
			@Override
			public void onAccountUpdate(long lastUpdate, Map<String, Asset> newBalance) {
				for (Entry<String, Asset> entry : newBalance.entrySet())
					System.out.println(entry.getValue());
			}
		});
	}


}
