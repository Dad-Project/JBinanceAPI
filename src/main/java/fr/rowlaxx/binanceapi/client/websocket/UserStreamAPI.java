package fr.rowlaxx.binanceapi.client.websocket;

import java.io.IOException;
import java.util.Objects;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpClient;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest;
import fr.rowlaxx.binanceapi.client.http.Parameters;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;
import fr.rowlaxx.binanceapi.exceptions.BinanceHttpClientException;

public abstract class UserStreamAPI extends StreamAPI {
	
	//Variables
	private final String endpoint;
	private final BinanceHttpClient httpClient;
	
	//Constructeurs
	public UserStreamAPI(String baseUrl, BinanceHttpClient httpClient, String endpoint) {
		super(baseUrl);
		this.endpoint = endpoint;
		this.httpClient = httpClient;
	}
	
	//Methodes
	@Override
	public void close() {
		deleteListenKey();
		super.close();
	}
	
	private void updateListenKey() {
		final BinanceHttpRequest request = BinanceHttpRequest.newBuilder(endpoint, Method.GET)
				.addSignature(true)
				.setBaseEndpoint(BaseEndpoints.SPOT)
				.build();
		
		try {
			setListenKey(((JSONObject)httpClient.execute(request)).getString("listenKey"));
		} catch (IOException e) {
			throw new BinanceHttpClientException(e.getMessage());
		}
	}
	
	private void putListenKey() {
		final BinanceHttpRequest request = BinanceHttpRequest.newBuilder(endpoint, Method.PUT)
				.addSignature(true)
				.setBaseEndpoint(BaseEndpoints.SPOT)
				.addParameter(Parameters.listenKey, getListenKey())
				.build();
		
		try {
			httpClient.execute(request);
		} catch (IOException e) {
			throw new BinanceHttpClientException(e.getMessage());
		}
	}
	
	private void deleteListenKey() {
		final BinanceHttpRequest request = BinanceHttpRequest.newBuilder(endpoint, Method.DELETE)
				.addSignature(true)
				.setBaseEndpoint(BaseEndpoints.SPOT)
				.addParameter(Parameters.listenKey, getListenKey())
				.build();
		
		try {
			httpClient.execute(request);
		} catch (IOException e) {
			throw new BinanceHttpClientException(e.getMessage());
		}
	}
	

}
