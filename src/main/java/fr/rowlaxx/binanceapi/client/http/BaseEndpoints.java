package fr.rowlaxx.binanceapi.client.http;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public enum BaseEndpoints {

	SPOT("https://api.binance.com", "https://api1.binance.com", "https://api2.binance.com", "https://api3.binance.com"),
	FUTURE_USD("https://fapi.binance.com"),
	FUTURE_COIN("https://dapi.binance.com"),
	VANILLE("https://vapi.binance.com"),
	CUSTOM;
	
	//Variables
	private final List<String> urls;
	
	//Constructeurs
	private BaseEndpoints(String... urls) {
		final ArrayList<String> array = new ArrayList<>();
		for (String s : urls)
			array.add(s);
		this.urls = Collections.unmodifiableList(array);
	}
	
	//Getters
	public List<String> getUrls() {
		return urls; 
	}
	
	
}