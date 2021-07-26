package fr.rowlaxx.binanceapi.client.websocket;

import java.io.Closeable;
import java.io.IOException;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

public class BinanceWebSocket implements Closeable {

	//Variables
	private final Set<String> subsriptions = new HashSet<>();
	private final String name;
	private final BinanceWebSocketConnector connector;
	final BinanceWebSocketListener listener;
	
	private volatile boolean closed = false;
	private int id = 0;
	
	WebSocket socket;
	JSONObject response = null;
	
	//Constructeurs
	public BinanceWebSocket(String baseurl, String name, BinanceWebSocketListener listener) {
		this.listener = Objects.requireNonNull(listener, "listener may not be null.");
		this.name = Objects.requireNonNull(name, "name may not be null.");
		this.connector = new BinanceWebSocketConnector(baseurl, this);
		this.connector.start();
	}

	//Methodes
	public void subscribe(String... params) {
		final List<String> p = new ArrayList<>(params.length);
		for (String param : params)
			p.add(param);
		subscribe(p);
	}
	
	public void subscribe(List<String> params) {
		final JSONObject request = new JSONObject();
		request.put("method", "SUBSCRIBE");
		final JSONArray array = new JSONArray(params.size() );
		for (String param : params)
			array.put(param);
		request.put("params", array);
		final JSONObject response = send(request);
		if (response.get("result") == JSONObject.NULL ) {
			for (String param : params)
				subsriptions.add(param);
		}
	}
	
	public void unsubscribe(String... params) {
		final JSONObject request = new JSONObject();
		request.put("method", "UNSUBSCRIBE");
		final JSONArray array = new JSONArray(params.length);
		for (String param : params)
			array.put(param);
		request.put("params", array);
		final JSONObject response = send(request);
		if (response.getString("result") == null) {
			for (String param : params)
				subsriptions.remove(param);
		}
	}
	
	public JSONObject send(JSONObject json) {
		json.put("id", id);
		socket.sendText(json.toString(), true);
		
		try {
			synchronized (this) {
				this.wait(10_000);
				
				if (this.response == null)
					throw new BinanceWebSocketException("Timed out.");
				
				if (this.response.optInt("id", -1) != this.id)
					throw new BinanceWebSocketException("Wrong response.");
				
				id++;
				return this.response;
			}
		}catch(InterruptedException e) {
			return null;
		}finally {
			this.response = null;
		}
	}
	
	public List<String> listSubscriptions() {
		return new ArrayList<>(subsriptions);
	}
	
	public void setCombined(boolean combined) {
		final JSONObject request = new JSONObject();
		request.put("method", "SET_PROPERTY");
		final JSONArray array = new JSONArray(1);
		array.put("combined");
		array.put(combined);
		request.put("params", array);
		send(request);
	}
	
	public boolean isCombined() {
		final JSONObject request = new JSONObject();
		request.put("method", "GET_PROPERTY");
		final JSONArray array = new JSONArray(1);
		array.put("combined");
		request.put("params", array);
		
		final JSONObject response = send(request);
		return response.getBoolean("result");
	}
	
	//Close
	public void testClose() {
		this.socket.abort();
	}
	
	@Override
	public void close() throws IOException {
		if (closed)
			return;
		
		synchronized (this) {
			this.connector.interrupt();
			try {
				this.connector.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.socket.abort();
			this.socket = null;
			this.closed = true;
		}
	}
	
	//Getter
	public boolean isClosed() {
		return closed;
	}

	public String getName() {
		return name;
	}
	
}
