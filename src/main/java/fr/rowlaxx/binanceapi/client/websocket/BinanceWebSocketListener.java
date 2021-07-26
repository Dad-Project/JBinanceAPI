package fr.rowlaxx.binanceapi.client.websocket;

import org.json.JSONObject;

public interface BinanceWebSocketListener {
	
	default void onJson(BinanceWebSocket socket, JSONObject json) {}
	default void onOpen(BinanceWebSocket socket) {}
	default void onClose(BinanceWebSocket socket) {}
	default void onPing(BinanceWebSocket socket) {}
	default void onPong(BinanceWebSocket socket) {}
	
}
