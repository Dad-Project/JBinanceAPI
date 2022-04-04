package fr.rowlaxx.binanceapi.client.websocket;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import fr.rowlaxx.binanceapi.exceptions.BinanceWebSocketException;

public class BinanceWebSocketPool implements Closeable {

	//Variables
	private final String baseUrl;
	final List<BinanceWebSocket> sockets = new ArrayList<>();
	private final LinkedList<Object> responses = new LinkedList<>();
	private final OnJsonReceived onJsonReceived;
	
	private ResponseProcessorThread responseProcessorThread;
	private PoolThread poolThread;
	
	//Constructeurs
	public BinanceWebSocketPool(String baseUrl, OnJsonReceived event) {
		this.baseUrl = Objects.requireNonNull(baseUrl, "baseUrl may not be null.");
		this.onJsonReceived = Objects.requireNonNull(event, "event may not be null.");
		initThreads();
	}
	
	private void initThreads() {
		if (responseProcessorThread == null) {
			this.responseProcessorThread = new ResponseProcessorThread(this, onJsonReceived);
			this.responseProcessorThread.start();
		}
		if (poolThread == null) {
			this.poolThread = new PoolThread(this);
			this.poolThread.start();	
		}
	}
	
	//Methodes
	void add(Object json) {
		synchronized (responses) {
			if (responses.size() >= 4096)
				throw new BinanceWebSocketException("Buffer has been filled.");
			responses.add(json);
			responses.notify();
		}
	}
	
	@SuppressWarnings("unchecked")
	<T> T nextResponse() throws InterruptedException {
		synchronized (responses) {
			while (responses.size() == 0)
				responses.wait();
			return (T) responses.removeFirst();
		}
	}
	
	public void subscribe(List<String> params) {
		if (params == null)
			return;
		
		int index = 0;
		BinanceWebSocket socket;
		while(params.size() != 0) {
			if (sockets.size() > index)
				socket = sockets.get(index);
			else {
				socket = new BinanceWebSocket(this);
				sockets.add(socket);
			}
			
			socket.subscribe(params);
			index++;
		}
	}
	
	public void subscribe(String param) {
		final List<String> list = new ArrayList<>();
		list.add(param );
		subscribe(list);
	}
	
	public void unsubscribe(List<String> params) {
		for (BinanceWebSocket socket : sockets)
			socket.unsubscribe(params);
	}
	
	public synchronized void unsubscribeAll() {
		if (sockets.size() > 0)
			sockets.get(0).unsubscribeAll();
		
		while (sockets.size() > 1)
			sockets.remove(1).close();
	}
	
	public void unsubscribe(String param) {
		for (BinanceWebSocket socket : sockets)
			socket.unsubscribe(param);
	}
	
	public synchronized void reconnectIfNeeded() {
		initThreads();
		
		for (BinanceWebSocket socket : sockets)
			socket.reconnectIfNeeded();
	}
	
	@Override
	public synchronized void close() {
		this.poolThread.interrupt();
		this.poolThread = null;
		
		for (BinanceWebSocket socket : sockets)
			socket.close();
		
		this.responseProcessorThread.interrupt();
		this.responseProcessorThread = null;
	}
	
	public int getSubscribtionCount() {
		int count = 0;
		for (BinanceWebSocket socket : sockets)
			count += socket.getSubscribtionCount();
		return count;
	}
	
	public String getBaseUrl() {
		return baseUrl;
	}

	public boolean isSubscribed(String param) {
		for (BinanceWebSocket socket : sockets)
			if (socket.isSubscribed(param))
				return true;
		return false;
	}
	
}
