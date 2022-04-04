package fr.rowlaxx.binanceapi.client.websocket;

import java.net.http.WebSocket;
import java.net.http.WebSocket.Listener;
import java.util.Objects;
import java.util.concurrent.CompletionStage;

import org.json.JSONArray;
import org.json.JSONObject;

public class WebSocketListener implements WebSocket.Listener {

	//Variables
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
	public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean lastChar) {
		if (!lastChar)
			throw new IllegalArgumentException("not the last char " + data);
			
		final char first = data.charAt(0);
		final char last = data.charAt(data.length() - 1);
		
		if (first == '{' && last == '}') {
			final JSONObject json = new JSONObject(data.toString());
			if (json.has("id"))
				this.webSocket.complete(json);
			else
				this.webSocket.getPool().add(json);
		}
		else if (first == '[' && last == ']')
			this.webSocket.getPool().add(new JSONArray(data.toString()));
		
		return WebSocket.Listener.super.onText(webSocket, data, lastChar);
	}
}
