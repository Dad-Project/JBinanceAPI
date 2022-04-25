package fr.rowlaxx.binanceapi.client.websocket;

import java.util.Objects;

public class SocketCheckerThread extends Thread {

	//Variables
	private final BinanceWebSocketPool pool;
	private boolean running;
	
	//Constructeurs
	public SocketCheckerThread(BinanceWebSocketPool pool) {
		this.pool = Objects.requireNonNull(pool, "pool may not be null.");
	}
	
	@Override
	public void run() {
		running = true;
		try {
			while (running) {
				pool.checkSockets();
				Thread.sleep(2000);
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
