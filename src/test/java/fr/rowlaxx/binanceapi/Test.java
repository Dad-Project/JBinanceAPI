package fr.rowlaxx.binanceapi;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.concurrent.ExecutionException;
import fr.rowlaxx.binanceapi.client.BinanceClient;

public class Test {

	public static final String API_KEY = "ZaCevetiE3qBRZ3G21JMRVbq5qGINzpFhGCEOVapSy7Hvk8swcpDM5c2ZY55UHOG";
	public static final String API_SECRET = "1M1ZXUBaoDG4kYLrTLfcgVOeXuOrrz2l77mXLNjpe8AcQdPXYS3AOebviFPfjDMx";
	
	public static void main(String[] args) throws UnknownHostException, IOException, URISyntaxException, InterruptedException, ExecutionException {
				
		final BinanceClient client = BinanceClient.create(API_KEY, API_SECRET);
		client.login();
		
		client.blvt().getBLVTUserLimitInfo("BTCUP");
	}	
}