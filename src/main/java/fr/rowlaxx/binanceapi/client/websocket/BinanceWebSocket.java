package fr.rowlaxx.binanceapi.client.websocket;

import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.exceptions.BinanceWebSocketException;

public class BinanceWebSocket implements Closeable {

	//Variables statiques
	public static final int MAX_SUBSCRIPTION = 1000;
	public static final int BATCH_SIZE = 200;
	
	//Variables
	private final String name;
	private final WebSocketListener listener;
	private final BinanceWebSocketPool pool;
	private WebSocket websocket;
	
	private final Set<String> subsriptions = new HashSet<>(MAX_SUBSCRIPTION);
	private final HashMap<Integer, CompletableFuture<JSONObject>> pendingResponse = new HashMap<>();
	
	private long timeout = 10000;
	private volatile int id = 0;
		
	//Constructeurs
	public BinanceWebSocket(BinanceWebSocketPool pool) {
		this.pool = Objects.requireNonNull(pool, "pool may not be null.");
		this.name = UUID.randomUUID().toString().replaceAll("-", "");
		this.listener = new WebSocketListener(this);
		initWebSocket();
	}
	
	private synchronized void initWebSocket() {
		if (websocket != null)
			throw new IllegalStateException("A websocket already exists.");
		
		try {
			final URI uri = new URI(pool.getBaseUrl() + "/ws/" + name);
			this.websocket = HttpClient.newHttpClient().newWebSocketBuilder().buildAsync(uri, listener).get();
		} catch (URISyntaxException e) {
			throw new BinanceWebSocketException("Illegal baseUrl");
		} catch (InterruptedException e) {
			return;
		} catch (ExecutionException e) {
			throw new BinanceWebSocketException(e.getCause().getMessage());
		}
	}

	//Methodes
	private final JSONObject buildRequest(String method, Collection<String> params) {
		final JSONObject request = new JSONObject();
		request.put("method", method);
		if (params != null) {
			final JSONArray array = new JSONArray(params.size());
			for (String param : params)
				array.put(param.toLowerCase());
			request.put("params", array);
		}
		request.put("id", id++);
		return request;
	}
	
	public Object send(JSONObject json) {
		final int id = json.getInt("id");
		final CompletableFuture<JSONObject> future = new CompletableFuture<>();
		
		try{
			pendingResponse.put(id, future);
			try{
				websocket.sendText(json.toString(), true).get();
			}catch(ExecutionException e) {
				throw new BinanceWebSocketException("Unable to send the JSON : " + e.getCause().getMessage());
			}
			
			try {
				final JSONObject response =  future.get(10_000, TimeUnit.MILLISECONDS);
				if (response.has("error")) {
					final JSONObject error = response.getJSONObject("error");
					throw new BinanceWebSocketException("code " + error.getInt("code") + " : " + error.getString("msg"));
				}
				return response.get("result");
			}catch (ExecutionException e) {
				throw new BinanceWebSocketException(e.getCause().getMessage());
			}catch (TimeoutException e) {
				throw new BinanceWebSocketException("Timed out.");
			} 
		}catch(InterruptedException e) {
			return null;
		}finally {
			pendingResponse.remove(id);
		}
	}
	
	void complete(JSONObject json) {
		final int id = json.getInt("id");
		final CompletableFuture<JSONObject> completableFuture = pendingResponse.get(id);
		completableFuture.complete(json);
	}
	
	private synchronized void forceSubscribe() {
		final List<String> list = new ArrayList<>(BATCH_SIZE);
		
		for (String s : subsriptions) {
			list.add(s);
			if (list.size() == BATCH_SIZE || list.size() + subsriptions.size() == MAX_SUBSCRIPTION) {
				send(buildRequest("SUBSCRIBE", list));
				list.clear();
			}
		}
		
		if (list.size() == 0)
			return;
		
		send(buildRequest("SUBSCRIBE", list));
	}
	
	public synchronized boolean subscribe(List<String> params) {
		if (params == null )
			return true;
		
		if (subsriptions.size() >= MAX_SUBSCRIPTION)
			return params.isEmpty();
		
		final List<String> list = new ArrayList<>(BATCH_SIZE);
		
		for (int i = params.size() - 1 ; i >= 0; i--) {
			if (isSubscribed(params.get(i))) {
				params.remove(i);
				continue;
			}
			
			if (subsriptions.size() + list.size() < MAX_SUBSCRIPTION) {
				list.add(params.remove(i));
				if (list.size() == BATCH_SIZE || list.size() + subsriptions.size() == MAX_SUBSCRIPTION) {
					send(buildRequest("SUBSCRIBE", list));
					subsriptions.addAll(list);
					list.clear();
				}
			}
		}
		
		if (list.size() == 0)
			return params.isEmpty();
		
		send(buildRequest("SUBSCRIBE", list));
		this.subsriptions.addAll(list);
		
		return params.isEmpty();
	}
	
	public synchronized void unsubscribe(List<String> params) {
		if (params == null)
			return;
		
		final ArrayList<String> list = new ArrayList<>(BATCH_SIZE);
		for (int i = params.size() - 1 ; i >= 0 ; i--)
			if (isSubscribed(params.get(i))) {
				list.add(params.remove(i));
				
				if (list.size() == BATCH_SIZE) {
					send(buildRequest("UNSUBSCRIBE", list));
					list.clear();
				}
			}
		
		if (list.size() == 0)
			return;
		
		send(buildRequest("UNSUBSCRIBE", list));
		this.subsriptions.removeAll(list);
	}
	
	public void unsubscribe(String param) {
		unsubscribe(Collections.singletonList(param));
	}

	@Override
	public synchronized void close() {
		if (this.websocket == null)
			return;
		
		this.websocket.sendClose(WebSocket.NORMAL_CLOSURE, "ok");
		this.websocket.abort();
		this.websocket = null;
	}
	
	private synchronized boolean reconnect() {
		try {
			close();
			initWebSocket();
			forceSubscribe();
			return true;
		}catch(BinanceWebSocketException e) {
			close();
			return false;
		}
		
	}
	
	public synchronized boolean reconnectIfNeeded() {
		if (websocket == null)
			return reconnect();
		else if (websocket.isInputClosed() || websocket.isOutputClosed())
			return reconnect();
		return false;
	}
	
	//Getters
	public long getTimeout() {
		return timeout;
	}
	
	public boolean isSubscribed(String param) {
		if (param == null)
			return false;
		return subsriptions.contains(param.toLowerCase());
	}
	
	public BinanceWebSocketPool getPool() {
		return pool;
	}
	
	public int getSubscribtionCount() {
		return subsriptions.size();
	}
	
	public String getName() {
		return name;
	}
	
	//Setters
	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}	
}
