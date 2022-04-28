package fr.rowlaxx.binanceapi.client.websocket;

import java.io.Closeable;
import java.util.LinkedList;
import java.util.Objects;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.api.Api;

public abstract class StreamAPI implements Api.WebSocket, Closeable {

	//Variables
	protected final BinanceWebSocketPool pool;
	
	protected static enum AppendMode {LOWER_CASE, UPPER_CASE, KEEP; }
	
	protected static final Iterable<String> append(Iterable<String> list, String suffix, AppendMode mode){
		final LinkedList<String> bak = new LinkedList<>();
		for(String s : list)
			if (mode == AppendMode.KEEP)
				bak.add(s + suffix);
			else if (mode == AppendMode.LOWER_CASE)
				bak.add(s.toLowerCase() + suffix);
			else
				bak.add(s.toUpperCase() + suffix);
		return bak;
	}
	
	protected static final String[] append(String[] params, String suffix, AppendMode mode) {
		String[] tab = new String[params.length];
		for (int i = 0 ; i < params.length ; i++)
			if (mode == AppendMode.KEEP)
				tab[i] = params[i] + suffix;
			else if (mode == AppendMode.LOWER_CASE)
				tab[i] = params[i].toLowerCase() + suffix;
			else
				tab[i] = params[i].toUpperCase() + suffix;
		return tab;
	}
	
	//Constructeurs
	public StreamAPI(String baseUrl, String listenKey) {
		this.pool = new BinanceWebSocketPool(baseUrl, listenKey, (JSONObject json) -> StreamAPI.this.onJson(json));
	}
	
	public StreamAPI(String baseUrl) {
		this.pool = new BinanceWebSocketPool(baseUrl, (JSONObject json) -> StreamAPI.this.onJson(json));
	}
	
	public StreamAPI(BinanceWebSocketPool pool) {
		this.pool = Objects.requireNonNull(pool, "pool may not be null.");
		this.pool.addOnJsonEvent((JSONObject json) -> StreamAPI.this.onJson(json));
	}
	
	public abstract void clearEvents();
	protected abstract void onJson(JSONObject json);
	
	@Override
	public void close() {
		pool.close();
	}
	
	protected boolean setListenKey(String listenKey) {
		return pool.setListenKey(listenKey);
	}
	
	public String getBaseUrl() {
		return pool.getBaseUrl();
	}
	
	public String getListenKey() {
		return pool.getListenKey();
	}
}