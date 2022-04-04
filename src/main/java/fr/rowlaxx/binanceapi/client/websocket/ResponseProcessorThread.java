package fr.rowlaxx.binanceapi.client.websocket;

import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResponseProcessorThread extends Thread {

	//Variables
	private final OnJsonReceived onJsonReceived;
	private final BinanceWebSocketPool pool;
	private boolean running;
	
	//Constructeus
	public ResponseProcessorThread(BinanceWebSocketPool pool, OnJsonReceived onJsonReceived) {
		this.onJsonReceived = Objects.requireNonNull(onJsonReceived, "onJsonReceived may not be null.");
		this.pool = Objects.requireNonNull(pool, "pool may not be null.");
	}
	
	@Override
	public void run() {
		running = true;
		Object object;
		try {
			while(running) {
				if ( (object = pool.nextResponse()) instanceof JSONObject)
					onJsonReceived.onJson((JSONObject)object);
				else
					onJsonReceived.onJson((JSONArray)object);
			}
		}catch(InterruptedException e) {
			return;
		}
	}
	
	@Override
	public void interrupt() {
		this.running = false;
		super.interrupt();
		try {
			this.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
