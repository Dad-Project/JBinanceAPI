package fr.rowlaxx.binanceapi.client.websocket;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.exceptions.BinanceWebSocketException;

public class BinanceWebSocketPool implements Closeable {

	//Variables
	private final String baseUrl;
	private final String listenKey;
	
	private final List<BinanceWebSocket> sockets = new ArrayList<>();
	private final LinkedList<JSONObject> responses = new LinkedList<>();
	private final List<OnJson> onJson = new LinkedList<>();
	private final OnJson socketOnJson = (JSONObject json) -> {
		if (json == null)
			return;
		
		synchronized (responses) {
			if (responses.size() >= 0xFFFF)
				throw new BinanceWebSocketException("Buffer has been filled.");
			
			responses.add(json);
			responses.notify();
		}
	};
	
	private ResponseProcessorThread processorThread;
	private SocketReconnectorThread reconnectorThread;
	
	//Constructeurs
	public BinanceWebSocketPool(String baseUrl, String listenKey, OnJson onJson) {
		this.baseUrl = Objects.requireNonNull(baseUrl, "baseUrl may not be null.");
		this.listenKey = listenKey;
		addOnJsonEvent(onJson);
		initThreads();
	}
	
	public BinanceWebSocketPool(String baseUrl) {
		this(baseUrl, null, null);
	}
	
	public BinanceWebSocketPool(String baseUrl, String listenKey) {
		this(baseUrl, listenKey, null);
	}
	
	public BinanceWebSocketPool(String baseUrl, OnJson onJson) {
		this(baseUrl, null, onJson);
	}
	
	private void initThreads() {
		if (processorThread == null) {
			this.processorThread = new ResponseProcessorThread(this);
			this.processorThread.start();
		}
		if (reconnectorThread == null) {
			this.reconnectorThread = new SocketReconnectorThread(this);
			this.reconnectorThread.start();	
		}
	}
	
	//Methodes reecrites
	@Override
	public synchronized void close() {
		this.reconnectorThread.interrupt();
		try {
			this.reconnectorThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.reconnectorThread = null;
		
		
		for (BinanceWebSocket socket : sockets)
			socket.close();
		
		this.processorThread.interrupt();
		try {
			this.processorThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.processorThread = null;
	}
	
	//Methodes
	JSONObject nextResponse() throws InterruptedException {
		synchronized (responses) {
			while (responses.size() == 0)
				responses.wait();
			
			return responses.removeFirst();
		}
	}
	
	public synchronized void subscribe(Iterable<String> params) {
		int new_ = 0;
		for (String param : params)
			if (!isSubscribed(param))
				new_++;
		
		final int total = new_ + getSubscribtionCount();
		final int socketCount = total / BinanceWebSocket.MAX_SUBSCRIPTION + (total % BinanceWebSocket.MAX_SUBSCRIPTION == 0 ? 0 : 1);
		
		while (this.sockets.size() < socketCount)
			this.sockets.add(new BinanceWebSocket(baseUrl, listenKey, socketOnJson));
		
		BinanceWebSocket socket;
		for (int index = 0; params != null; index++)
			params = sockets.get(index).subscribe(params);
	}
	
	public synchronized void subscribe(String[] params) {
		subscribe(Arrays.asList(params));
	}
	
	public synchronized void subscribe(String param) {
		subscribe(Arrays.asList(param));
	}
	
	public void unsubscribe(Iterable<String> params) {
		for (BinanceWebSocket socket : sockets)
			socket.unsubscribe(params);
	}
	
	public void unsubscribe(String[] params) {
		unsubscribe(Arrays.asList(params));
	}
	
	public void unsubscribe(String param) {
		unsubscribe(Arrays.asList(param));
	}
	
	public void unsubscribeAll() {
		for (BinanceWebSocket socket : sockets)
			socket.unsubscribeAll();
	}
	
	public synchronized void reconnectIfNeeded() {
		initThreads();
		for (BinanceWebSocket socket : sockets)
			socket.reconnectIfNeeded();
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
	
	public String getListenKey() {
		return listenKey;
	}

	public boolean isSubscribed(String param) {
		for (BinanceWebSocket socket : sockets)
			if (socket.isSubscribed(param))
				return true;
		return false;
	}
	
	List<OnJson> getOnJsonEvents(){
		return onJson;
	}
	
	public void addOnJsonEvent(OnJson onJson) {
		if (onJson == null)
			return;
		this.onJson.add(onJson);
	}
	
}
