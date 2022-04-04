package fr.rowlaxx.binanceapi.client.websocket;

import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.util.Objects;
import java.util.concurrent.CompletionStage;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebSocketListener implements WebSocket.Listener {

	//Variables
	private StringBuilder sb = new StringBuilder();
	private BinanceWebSocket webSocket;
	
	//Constructeurs
	public WebSocketListener(BinanceWebSocket webSocket) {
		this.webSocket = Objects.requireNonNull(webSocket, "webSocket may not be null.");
	}
	
	//Methodes
	@Override
	public void onError(WebSocket webSocket, Throwable error) {
		this.webSocket.reconnectIfNeeded();
		Listener.super.onError(webSocket, error);
	}
	
	
	
	@Override
	public synchronized CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean lastChar) {
		if (sb.length() > 0 || !lastChar) {
			sb.append(data);
			if (!lastChar)
				return WebSocket.Listener.super.onText(webSocket, data, lastChar);
			else {
				data = sb.toString();
				sb = new StringBuilder();
			}
		}
		
		this.webSocket.updateLastReceived();
		final char first = data.charAt(0);
		final char last = data.charAt(data.length() - 1);
		
		try {
			if (first == '{' && last == '}') {
				final JSONObject json = new JSONObject(data.toString());
				if (json.has("id"))
					this.webSocket.complete(json);
				else
					this.webSocket.getPool().add(json);
			}
			else if (first == '[' && last == ']')
				this.webSocket.getPool().add(new JSONArray(data.toString()));
			
		}catch(JSONException e) {
			e.printStackTrace();
		}
		
		return WebSocket.Listener.super.onText(webSocket, data, lastChar);
	}
}
