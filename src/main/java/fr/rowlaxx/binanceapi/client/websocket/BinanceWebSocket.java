package fr.rowlaxx.binanceapi.client.websocket;

import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.exceptions.BinanceWebSocketException;
import fr.rowlaxx.jsavon.Jsavon;
import fr.rowlaxx.utils.ParameterizedClass;

public class BinanceWebSocket implements Closeable {

	//Variables statiques
	public static final int MAX_SUBSCRIPTION = 1000;
	public static final int BATCH_SIZE = 200;
	
	//Variables
	private final String baseUrl;
	private final String listenKey;
	private final URI uri;
	
	private final List<OnJson> onJson = new LinkedList<>();
	private CompletableFuture<WebSocket> websocket;
	
	
	private final Set<String> subsriptions = new HashSet<>(MAX_SUBSCRIPTION);
	private final HashMap<Integer, CompletableFuture<Object>> responses = new HashMap<>();
	
	private volatile int id = 0;
		
	//Constructeurs
	public BinanceWebSocket(String baseUrl, String listenKey) {
		this.baseUrl = Objects.requireNonNull(baseUrl, "baseUrl may not be null.");
		this.listenKey = listenKey;
		
		try {
			if (listenKey == null)
				this.uri = new URI(baseUrl);
			else
				this.uri = new URI(baseUrl + "/ws/" + listenKey);
		}catch(URISyntaxException e) {
			throw new BinanceWebSocketException(e.getMessage());
		}
		
		buildWebSocketAsync();
	}
	
	public BinanceWebSocket(String baseUrl) {
		this(baseUrl, (String)null);
	}
	
	public BinanceWebSocket(String baseUrl, String listenKey, OnJson onJson) {
		this(baseUrl, listenKey);
		addOnJsonEvent(onJson);
	}
	
	public BinanceWebSocket(String baseUrl, OnJson onJson) {
		this(baseUrl, (String)null);
		addOnJsonEvent(onJson);
	}
	
	private synchronized void buildWebSocketAsync() {
		if (websocket != null)
			throw new IllegalStateException("A websocket already exists.");
		
		this.websocket = HttpClient.newHttpClient().newWebSocketBuilder().buildAsync(uri, new WebSocketListener(this));
	}

	//Methodes
	private final JSONObject buildRequest(String method, Collection<String> params) {
		final JSONObject request = new JSONObject();
		request.put("method", method);
		if (params != null) {
			final JSONArray array = new JSONArray(params.size());
			for (String param : params)
				array.put(param);
			request.put("params", array);
		}
		request.put("id", id++);
		return request;
	}
	
	
	private CompletableFuture<Object> send(JSONObject json) {
		final int id = json.getInt("id");
		final CompletableFuture<Object> future = new CompletableFuture<>();
		
		synchronized (responses) {
			responses.put(id, future);
		}
			
		websocket().sendText(json.toString(), true);
		return future;
	}
	
	
	void complete(JSONObject json) {
		final int id = json.getInt("id");
		CompletableFuture<Object> response;
		
		synchronized (responses) {
			response = responses.remove(id);
		}

		if (json.has("error")) {
			final JSONObject error = json.getJSONObject("error");
			response.completeExceptionally(new BinanceWebSocketException("code " + error.getInt("code") + " : " + error.getString("msg")));
		}
		
		response.complete(json.get("result"));
	}
	
	void onJson(JSONObject json) {
		for (OnJson event : onJson)
			event.onJson(json);
	}
	
	public synchronized Iterable<String> subscribe(Iterable<String> params) {
		if (params == null)
			return null;
		
		final List<String> batch = new ArrayList<>(BATCH_SIZE);
		final List<String> remaining = new LinkedList<>();
		
		for (String s : params)
			if (isSubscribed(s))
				continue;
			else if (this.subsriptions.size() >= MAX_SUBSCRIPTION)
				remaining.add(s);
			else {
				batch.add(s);
				if (batch.size() == BATCH_SIZE || this.subsriptions.size() + batch.size() >= MAX_SUBSCRIPTION) {
					send(buildRequest("SUBSCRIBE", batch));
					this.subsriptions.addAll(batch);
					batch.clear();
				}
			}
		
		if (batch.size() > 0) {
			send(buildRequest("SUBSCRIBE", batch));
			this.subsriptions.addAll(batch);
		}
		
		if (remaining.size() == 0)
			return null;
		
		return remaining;
	}
	
	private void forceResubscribe() {
		synchronized (subsriptions) {
			final List<String> backup = new LinkedList<>(this.subsriptions);
			try {
				this.subsriptions.clear();
				subscribe(backup);
			}catch(Exception e) {
				this.subsriptions.addAll(backup);
				throw e;
			}
		}
	}
	
	public void subscribe(String[] channels) {
		subscribe(Arrays.asList(channels));
	}
	
	public void subscribe(String channel) {
		subscribe(Arrays.asList(channel));
	}
		
	public void unsubscribeAll() {
		unsubscribe(this.subsriptions);
	}
	
	public synchronized void unsubscribe(Iterable<String> params) {
		if (params == null)
			return;
		
		final ArrayList<String> batch = new ArrayList<>(BATCH_SIZE);
		for (String param : params) {
			if (isSubscribed(param))
				batch.add(param);
			
			if (batch.size() == BATCH_SIZE) {
				send(buildRequest("UNSUBSCRIBE", batch));
				this.subsriptions.removeAll(batch);
				batch.clear();
			}
		}
		
		if (batch.size() > 0) {
			send(buildRequest("UNSUBSCRIBE", batch));
			this.subsriptions.removeAll(batch);
		}
	}
	
	public void unsubscribe(String[] params) {
		unsubscribe(Arrays.asList(params));
	}
	
	public void unsubscribe(String param) {
		unsubscribe(Arrays.asList(param));
	}
	
	private WebSocket websocket() {
		try {
			return this.websocket.get();
		} catch (InterruptedException e) {
			return null;
		} catch(ExecutionException e) {
			throw new BinanceWebSocketException("The websocket could not be created : " + e);
		}
	}

	//Methodes reecrites
	@Override
	public synchronized void close() {
		if (this.websocket == null)
			return;
		
		websocket().sendClose(WebSocket.NORMAL_CLOSURE, "ok");
		websocket().abort();
		
		for (CompletableFuture<Object> responseFuture : responses.values())
			responseFuture.completeExceptionally(new BinanceWebSocketException("Socket has been closed."));
		responses.clear();
		
		this.websocket = null;
	}
	
	private synchronized boolean reconnect() {
		try {
			close();
			buildWebSocketAsync();
			forceResubscribe();
			return true;
		}catch(BinanceWebSocketException e) {
			close();
			return false;
		}
	}
	
	public synchronized boolean reconnectIfNeeded() {
		if (subsriptions.size() == 0)
			return true;
		
		if (websocket == null)
			return reconnect();
		else if (websocket().isInputClosed() || websocket().isOutputClosed())
			return reconnect();
		return false;
	}
	
	//Getters
	public boolean isSubscribed(String param) {
		if (param == null)
			return false;
		return subsriptions.contains(param);
	}
	
	public int getSubscribtionCount() {
		return subsriptions.size();
	}
	
	public List<String> listSubscriptions() {
		try {
			final JSONObject request = buildRequest("LIST_SUBSCRIPTIONS", null);
			final JSONArray response = (JSONArray) send(request).get();
			return Jsavon.converter.convert(response, ParameterizedClass.from(List.class, String.class));
		} catch (InterruptedException e) {
			return null;
		} catch (ExecutionException e) {
			throw new BinanceWebSocketException(e.getMessage());
		}
		
	}
	
	public String getBaseUrl() {
		return baseUrl;
	}
	
	public String getListenKey() {
		return listenKey;
	}
	
	//Setters
	public void addOnJsonEvent(OnJson onJson) {
		if (onJson == null)
			return;
		this.onJson.add(onJson);
	}
}
