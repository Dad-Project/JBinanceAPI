package fr.rowlaxx.binanceapi.client.websocket;

import java.util.Objects;

import org.json.JSONObject;

public class ResponseProcessorThread extends Thread {

	//Variables
	private final BinanceWebSocketPool pool;
	private boolean running;
	
	//Constructeus
	public ResponseProcessorThread(BinanceWebSocketPool pool) {
		this.pool = Objects.requireNonNull(pool, "pool may not be null.");
	}
	
	@Override
	public void run() {
		running = true;
		JSONObject json;
		try {
			while(running) {
				json = pool.nextResponse();
				for (OnJson event : pool.getOnJsonEvents())
					event.onJson(json);
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
