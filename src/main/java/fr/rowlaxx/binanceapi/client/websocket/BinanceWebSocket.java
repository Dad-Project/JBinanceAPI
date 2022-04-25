package fr.rowlaxx.binanceapi.client.websocket;

import java.io.Closeable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.HttpClient.Redirect;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.ExecutionException;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.exceptions.BinanceWebSocketException;
import fr.rowlaxx.jsavon.Jsavon;
import fr.rowlaxx.utils.ParameterizedClass;

public class BinanceWebSocket implements Closeable {

	//Variables statiques
	private static final HttpClient httpClient = HttpClient.newBuilder()
			.connectTimeout(Duration.ofSeconds(30))
			.followRedirects(Redirect.NEVER)
			.build();
	
	//Variables statiques
	public static final int MAX_SUBSCRIPTION = 1000;
	public static final int BATCH_SIZE = 200;

	//Variables
	private final String baseUrl;
	private final String listenKey;
	private final URI uri;

	private final List<OnJson> onJson = new LinkedList<>();
	private CompletableFuture<WebSocket> websocket;

	private long timeout = 30_000;
	private long lastPong = System.currentTimeMillis();
	private long lastPing = System.currentTimeMillis();

	private final Set<String> subsriptions = new HashSet<>(MAX_SUBSCRIPTION);
	private final HashMap<Integer, CompletableFuture<Object>> responses = new HashMap<>();

	private volatile int id = 0;

	//Constructeurs
	public BinanceWebSocket(String baseUrl, String listenKey) {
		this.baseUrl = Objects.requireNonNull(baseUrl, "baseUrl may not be null.");
		this.listenKey = listenKey;

		try {
			this.uri = new URI(baseUrl + "/ws/" + (listenKey == null ? UUID.randomUUID().toString().replaceAll("-", "") : listenKey));
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
		if (!isClosed())
			throw new IllegalStateException("A websocket already exists.");
		this.websocket = httpClient.newWebSocketBuilder().buildAsync(uri, new WebSocketListener(this));
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
		if (isClosed())
			return null;
		
		final int id = json.getInt("id");
		final CompletableFuture<Object> future = new CompletableFuture<>();

		synchronized (responses) {
			responses.put(id, future);
		}

		websocket().sendText(json.toString(), true);
		return future;
	}


	void complete(JSONObject json) {
		this.lastPong = System.currentTimeMillis();
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
		this.lastPong = System.currentTimeMillis();
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

	private synchronized void resubscribe() {
		final List<String> batch = new ArrayList<>(BATCH_SIZE);

		for (String s : subsriptions) {
			batch.add(s);
			if (batch.size() == BATCH_SIZE) {
				send(buildRequest("SUBSCRIBE", batch));
				batch.clear();
			}
		}

		if (batch.size() > 0)
			send(buildRequest("SUBSCRIBE", batch));
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
			throw new NullPointerException("The websocket could not be accessed : " + e.getMessage());
		} catch(ExecutionException e) {
			throw new NullPointerException("The websocket could not be created : " + e.getMessage());
		}
	}

	//Methodes reecrites
	@Override
	public synchronized void close() {
		if (isClosed())
			return;

		websocket().sendClose(WebSocket.NORMAL_CLOSURE, "ok");
		websocket().abort();

		for (CompletableFuture<Object> responseFuture : responses.values())
			responseFuture.completeExceptionally(new BinanceWebSocketException("Socket has been closed."));
		responses.clear();

		this.websocket = null;
	}

	private synchronized void reconnect() {
		try {
			close();
			buildWebSocketAsync();
			resubscribe();
		}catch(NullPointerException e) {
			this.websocket = null;
		}

	}

	public void ping() {
		try {
			websocket().sendPing(ByteBuffer.wrap("ok".getBytes()));
		} catch(Exception ignored) {
		} finally {
			this.lastPing = System.currentTimeMillis();
		}
	}

	public synchronized void verify() {
		if (subsriptions.size() == 0)
			return;
		
		if (isClosed())
			reconnect();
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
		if (isClosed())
			throw new BinanceWebSocketException("socket closed.");
		
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

	public long getTimeout() {
		return timeout;
	}

	public synchronized boolean isClosed() {
		if ( this.websocket == null )
			return true;
		try{
			this.websocket.join();
			return lastPing - lastPong > timeout;
		}catch(CompletionException e) {
			return true;
		}
	}

	//Setters
	public void addOnJsonEvent(OnJson onJson) {
		if (onJson == null)
			return;
		this.onJson.add(onJson);
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	void onPong() {
		this.lastPong = System.currentTimeMillis();
	}
}
