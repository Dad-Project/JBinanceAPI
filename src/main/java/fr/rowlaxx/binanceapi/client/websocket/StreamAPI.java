package fr.rowlaxx.binanceapi.client.websocket;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.api.Api;

public abstract class StreamAPI implements Api.WebSocket, Closeable {

	//Variables
	protected final BinanceWebSocketPool pool;
	
	protected static final List<String> append(List<String> list, String suffix){
		final ArrayList<String> bak = new ArrayList<>(list.size());
		for(String s : list)
			bak.add(s + suffix);
		return bak;
	}
	
	//Constructeurs
	public StreamAPI(String baseUrl) {
		this.pool = new BinanceWebSocketPool(baseUrl, new OnJsonReceived() {
			
			@Override
			public void onJson(JSONObject json) {
				StreamAPI.this.onJson(json);
			}
		});
	}
	
	public abstract void clearEvents();
	protected abstract void onJson(JSONObject json);

	@Override
	public void close() {
		pool.close();
	}
	
	public void open() {
		pool.reconnectIfNeeded();
	}
	
}
