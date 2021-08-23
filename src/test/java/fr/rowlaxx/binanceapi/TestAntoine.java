package fr.rowlaxx.binanceapi;

import java.io.IOException;

import fr.rowlaxx.binanceapi.client.BinanceClient;

public class TestAntoine {

	public static void main(String[] args) throws IOException {
		
		BinanceClient client = BinanceClient.create(Test.API_KEY, Test.API_SECRET);
		client.login();
		
	}
	
}
