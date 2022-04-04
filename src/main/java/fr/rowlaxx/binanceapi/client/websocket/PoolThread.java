package fr.rowlaxx.binanceapi.client.websocket;

import java.util.Objects;

public class PoolThread extends Thread {

	//Variables
	private final BinanceWebSocketPool pool;
	private boolean running;
	
	//Constructeurs
	public PoolThread(BinanceWebSocketPool pool) {
		this.pool = Objects.requireNonNull(pool, "pool may not be null.");
	}
	
	@Override
	public void run() {
		running = true;
		try {
			while (running) {
				pool.reconnectIfNeeded();
				Thread.sleep(5000);
			}
		}catch(InterruptedException e) {
			return;
		}
	}
	
	@Override
	public void interrupt() {
		running = false;
		super.interrupt();
		try {
			this.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
