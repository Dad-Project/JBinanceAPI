package fr.rowlaxx.binanceapi.client.websocket;

import java.util.Objects;

public class UserStreamAPIThread extends Thread {

	//Variables
	private final UserStreamAPI stream;
	private volatile boolean running = false;
	
	//Constructeurs
	public UserStreamAPIThread(UserStreamAPI stream) {
		this.stream = Objects.requireNonNull(stream, "stream may not be null.");
	}
	
	//Methodes
	@Override
	public void run() {
		running = true;
		while (running)			
			try {
				Thread.sleep(5*60*1000);
				stream.updateListenKey();
			} catch (InterruptedException e) {}	
	}
	
	@Override
	public void interrupt() {
		this.running = false;
		super.interrupt();
		try {
			this.join();
		} catch (InterruptedException e) {}
	}
}
