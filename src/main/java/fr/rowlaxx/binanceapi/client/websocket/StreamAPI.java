package fr.rowlaxx.binanceapi.client.websocket;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.api.Api;

public abstract class StreamAPI implements Api.WebSocket, Closeable {

	//Variables
	private BinanceWebSocketPool pool;
	
	protected static enum AppendMode {LOWER_CASE, UPPER_CASE, KEEP; }
	
	protected static final List<String> append(List<String> list, String suffix, AppendMode mode){
		final ArrayList<String> bak = new ArrayList<>(list.size());
		for(String s : list)
			if (mode == AppendMode.KEEP)
				bak.add(s + suffix);
			else if (mode == AppendMode.LOWER_CASE)
				bak.add(s.toLowerCase() + suffix);
			else
				bak.add(s.toUpperCase() + suffix);
		return bak;
	}
	
	//Constructeurs
	public StreamAPI(String baseUrl, String listenKey) {
		this.pool = new BinanceWebSocketPool(baseUrl, listenKey, (JSONObject json) -> StreamAPI.this.onJson(json));
	}
	
	public StreamAPI(String baseUrl) {
		this(baseUrl, null);
	}
	
	public StreamAPI(BinanceWebSocketPool pool) {
		this.pool = Objects.requireNonNull(pool, "pool may not be null.");
		this.pool.addOnJsonEvent((JSONObject json) -> StreamAPI.this.onJson(json));
	}
	
	public abstract void clearEvents();
	protected abstract void onJson(JSONObject json);

	protected void setNewWebSocketPool(BinanceWebSocketPool pool) {
		this.pool = Objects.requireNonNull(pool, "pool may not be null.");
	}
	
	@Override
	public void close() {
		pool.close();
	}
	
	public void reconnect() {
		pool.checkSockets();
	}
	
	protected void unsubscribeAll() {
		pool.unsubscribeAll();
	}
	
	protected void subscribe(Iterable<String> channels) {
		pool.subscribe(channels);
	}
	
	protected void subscribe(String[] channels) {
		pool.subscribe(channels);
	}
	
	protected void subscribe(String channel) {
		pool.subscribe(channel);
	}
	
	protected void unsubscribe(Iterable<String> channels) {
		pool.unsubscribe(channels);
	}
	
	protected void unsubscribe(String[] channels) {
		pool.unsubscribe(channels);
	}
	
	protected void unsubscribe(String channel) {
		pool.unsubscribe(channel);
	}
	
	public String getBaseUrl() {
		return pool.getBaseUrl();
	}
	
	public String getListenKey() {
		return pool.getListenKey();
	}
}