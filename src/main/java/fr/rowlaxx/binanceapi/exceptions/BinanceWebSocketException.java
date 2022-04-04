package fr.rowlaxx.binanceapi.exceptions;

public class BinanceWebSocketException extends BinanceException {
	private static final long serialVersionUID = 4588773260274532764L;

	public BinanceWebSocketException() {
		super();
	}

	public BinanceWebSocketException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public BinanceWebSocketException(String msg) {
		super(msg);
	}

	public BinanceWebSocketException(Throwable cause) {
		super(cause);
	}
	
}
