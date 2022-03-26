package fr.rowlaxx.binanceapi;

import java.io.IOException;

import fr.rowlaxx.binanceapi.api.ApiImplementer;
import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.core.savings.FixedProduct;
import fr.rowlaxx.binanceapi.core.savings.FixedTypes;
import fr.rowlaxx.binanceapi.core.savings.FlexibleProduct;
import fr.rowlaxx.binanceapi.core.savings.SavingsStatus;

public class Test {	

	private static BinanceClient client;
	
	public static void main(String[] args) throws IOException {
		client = BinanceClient.create(args[0], args[1]);
		client.login();
		ApiImplementer.DEBUG = true;
		
		for (FixedProduct a : client.savings().getFixedProducts(FixedTypes.ACTIVITY, 1, 100)) {
			System.out.println(a);
		}
	}
}
