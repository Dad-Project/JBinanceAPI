package fr.rowlaxx.binanceapi.client.websocket;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.exceptions.BinanceWebSocketException;

public class BinanceWebSocketPool implements Closeable {

	//Variables
	private final String baseUrl;
	private String listenKey;
	
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
	private SocketCheckerThread reconnectorThread;
	
	//Constructeurs
	public BinanceWebSocketPool(String baseUrl, String listenKey, OnJson onJson) {
		this.baseUrl = Objects.requireNonNull(baseUrl, "baseUrl may not be null.");
		this.listenKey = Objects.requireNonNull(listenKey, "listenKey may not be null.");
		addOnJsonEvent(onJson);
		initThreads();
	}
	
	public BinanceWebSocketPool(String baseUrl) {
		this(baseUrl, UUID.randomUUID().toString().replaceAll("-", ""), null);
	}
	
	public BinanceWebSocketPool(String baseUrl, String listenKey) {
		this(baseUrl, listenKey, null);
	}
	
	public BinanceWebSocketPool(String baseUrl, OnJson onJson) {
		this(baseUrl, UUID.randomUUID().toString().replaceAll("-", ""), onJson);
	}
	
	private void initThreads() {
		if (processorThread == null) {
			this.processorThread = new ResponseProcessorThread(this);
			this.processorThread.start();
		}
		if (reconnectorThread == null) {
			this.reconnectorThread = new SocketCheckerThread(this);
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
		
		if (new_ == 0)
			return;
		
		final int total = new_ + getSubscribtionCount();
		final int socketCount = total / BinanceWebSocket.MAX_SUBSCRIPTION + (total % BinanceWebSocket.MAX_SUBSCRIPTION == 0 ? 0 : 1);
		
		while (this.sockets.size() < socketCount)
			this.sockets.add(new BinanceWebSocket(baseUrl, listenKey, socketOnJson));
		
		for (int index = 0; params != null; index++)
			params = sockets.get(index).subscribe(params);
	}
	
	public synchronized void subscribe(String[] params) {
		subscribe(Arrays.asList(params));
	}
	
	public synchronized void subscribe(String param) {
		subscribe(Arrays.asList(param));
	}
	
	public synchronized void unsubscribe(Iterable<String> params) {
		for (BinanceWebSocket socket : sockets)
			socket.unsubscribe(params);
	}
	
	public synchronized void unsubscribe(String[] params) {
		unsubscribe(Arrays.asList(params));
	}
	
	public synchronized void unsubscribe(String param) {
		unsubscribe(Arrays.asList(param));
	}
	
	public synchronized void unsubscribeAll() {
		for (BinanceWebSocket socket : sockets)
			socket.close();
		sockets.clear();
	}
	
	synchronized void checkSockets() {
		initThreads();
		for (BinanceWebSocket socket : sockets) {
			socket.ping();
			socket.verify();
		}
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
	
	void addSocket(int count) {
		for (int i = 0 ; i < count ; i++)
			sockets.add(new BinanceWebSocket(baseUrl, listenKey, socketOnJson));
	}
	
	//Setters
	public void addOnJsonEvent(OnJson onJson) {
		if (onJson == null)
			return;
		this.onJson.add(onJson);
	}
	
	public synchronized boolean setListenKey(String listenKey) {
		Objects.requireNonNull(listenKey, "listenKey may not be null.");
		if (listenKey.equals(this.listenKey))
			return false;

		this.listenKey = listenKey;
		for (BinanceWebSocket socket : sockets)
			socket.setListenKey(listenKey);
		
		return true;
	}
	
}
