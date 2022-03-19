package fr.rowlaxx.binanceapi;

import fr.rowlaxx.binanceapi.client.BinanceClient;

public class Test {

	private final static BinanceClient client = Secret.client;
	
	
	public static void main(String[] args) {
		
		
		System.out.println(client.savings().getFlexibleProducts(null, null, null, null));
	}

}
