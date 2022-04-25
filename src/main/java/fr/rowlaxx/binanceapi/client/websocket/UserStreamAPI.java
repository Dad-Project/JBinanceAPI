package fr.rowlaxx.binanceapi.client.websocket;

import java.io.IOException;
import java.util.Objects;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.client.BinanceClient;
import fr.rowlaxx.binanceapi.client.http.BaseEndpoints;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest;
import fr.rowlaxx.binanceapi.client.http.BinanceHttpRequest.Method;

public abstract class UserStreamAPI extends StreamAPI {
	
	//Variables
	private final String endpoint;
	private final BinanceClient client;
	private UserStreamAPIThread thread;
	
	//Constructeurs
	public UserStreamAPI(String baseUrl, BinanceClient client, String endpoint) {
		super(baseUrl);
		this.endpoint = Objects.requireNonNull(endpoint, "endpoint may not be null.");
		this.client = Objects.requireNonNull(client, "client may not be null.");
		
		if (client.isGuest())
			throw new IllegalArgumentException("User streams are not for guest client.");
		
		updateListenKey();
		pool.addSocket(1);
		initThread();
	}
	
	//Methodes
	private void initThread() {
		if (thread == null) {
			thread = new UserStreamAPIThread(this);
			thread.start();
		}
	}
	
	@Override
	public void close() {
		thread.interrupt();
		thread = null;
		super.close();
	}
	
	boolean updateListenKey() {
		final BinanceHttpRequest request = BinanceHttpRequest.newBuilder(endpoint, Method.POST)
				.addSignature(false)
				.setBaseEndpoint(BaseEndpoints.SPOT)
				.build();
	
		
		try {
			final JSONObject response = client.getHttpClient().execute(request);
			return setListenKey(response.getString("listenKey"));
		} catch (IOException e) {
			return false;
		}
	}
	
}
