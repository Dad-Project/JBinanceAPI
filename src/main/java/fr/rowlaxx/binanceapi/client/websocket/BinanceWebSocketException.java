package fr.rowlaxx.binanceapi.client.websocket;

import fr.rowlaxx.binanceapi.exception.BinanceException;

public class BinanceWebSocketException extends BinanceException {
	private static final long serialVersionUID = 4588773260274532764L;

	public BinanceWebSocketException(String msg) {
		super(msg);
	}

}
