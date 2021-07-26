package fr.rowlaxx.binanceapi.client.websocket;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.net.http.HttpClient.Builder;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.WebSocket.Listener;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;
import org.json.JSONObject;

class BinanceWebSocketConnector extends Thread {

	//Variables
	private final BinanceWebSocket socket;
	private final HttpClient client;
	private final String baseurl;
	private boolean failed = false;
	
	//Constructeurs
	public BinanceWebSocketConnector(String baseurl, BinanceWebSocket socket) {
		super("Socket \"" + socket.getName() + "\" connector thread.");
		this.baseurl = Objects.requireNonNull(baseurl, "baseurl may not be null.");
		this.socket = Objects.requireNonNull(socket, "socket may not be null.");
		final Builder builder = HttpClient.newBuilder();
		builder.followRedirects(Redirect.NEVER);
		builder.proxy(Builder.NO_PROXY);
		builder.version(Version.HTTP_2);
		this.client = builder.build();
	}
	
	//Thread
	@Override
	public void run() {
		while ( !socket.isClosed() ) {
			try {
				Thread.sleep(failed ? 10_000 : 100);
				
				if (socket.socket == null)
					reconnect();
				else if (socket.socket.isInputClosed() || socket.socket.isOutputClosed())
					reconnect();
				
			} catch(InterruptedException e) {
				break;
			} 
		}
	}
	
	private void reconnect() {
		try {
			synchronized (socket) {
				System.err.println("Reconnecting to \"" + socket.getName() + "\"...");
				socket.socket = createNewSocket();
				System.out.println("Socket created.");
				socket.subscribe(socket.listSubscriptions());
				System.out.println("Reconnected !");
			}
			this.failed = false;
		}catch(Exception e) {
			e.printStackTrace();
			System.err.println("Unable to reconnect to \"" + socket.getName() + "\" : " + e);
			this.failed = true;
		}
	}
	
	@Override
	public synchronized void start() {
		try {
			socket.socket = createNewSocket();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		super.start();
	}
	
	//Creation de socket
	private final WebSocket createNewSocket() throws InterruptedException, IOException {
		final URI uri = URI.create(baseurl + "/ws/" + socket.getName() );
		final WebSocket.Builder builder = client.newWebSocketBuilder();
		builder.connectTimeout(Duration.ofMillis(10_000));
		try {
			return builder.buildAsync(uri, new WebSocket.Listener() {
			
				@Override
				public CompletionStage<?> onBinary(WebSocket webSocket, ByteBuffer data, boolean last) {
					return Listener.super.onBinary(webSocket, data, last);
				}
				
				@Override
				public CompletionStage<?> onClose(WebSocket webSocket, int statusCode, String reason) {
					socket.listener.onOpen(socket);
					return Listener.super.onClose(webSocket, statusCode, reason);
				}
				
				@Override
				public void onOpen(WebSocket webSocket) {
					socket.listener.onClose(socket);
					Listener.super.onOpen(webSocket);
				}
				
				@Override
				public CompletionStage<?> onPing(WebSocket webSocket, ByteBuffer message) {
					socket.listener.onPing(socket);
					return Listener.super.onPing(webSocket, message);
				}
				
				@Override
				public CompletionStage<?> onPong(WebSocket webSocket, ByteBuffer message) {
					socket.listener.onPong(socket);
					return Listener.super.onPong(webSocket, message);
				}
				
				@Override
				public void onError(WebSocket webSocket, Throwable error) {
					Listener.super.onError(webSocket, error);
				}
				
				private StringBuilder sb = new StringBuilder();
				@Override
				public CompletionStage<?> onText(WebSocket webSocket, CharSequence data, boolean last) {
					sb.append(data.toString() );
					if (last) {
						try{
							final JSONObject json = new JSONObject(sb.toString());
							if (json.has("id")) {
								synchronized (socket) {
									socket.response = json;
									socket.notifyAll();
								}
							}
							else {
								try {
									socket.listener.onJson(socket, json);
								}catch(Exception e) {
									System.err.println("Error with listener : ");
									e.printStackTrace();
								}
							}
						}catch(JSONException e) {
							System.err.println("Bad json : " + sb.toString() );
						}finally {
							sb = new StringBuilder();
						}	
					}
					return Listener.super.onText(webSocket, data, last);
				}
				
			}).get();
		} catch (ExecutionException e) {
			throw (IOException) e.getCause();
		}
	}
	
	//Getter
	public String getBaseurl() {
		return baseurl;
	}
}
