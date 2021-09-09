package fr.rowlaxx.binanceapi.exceptions;

public class ApiEndpointException extends BinanceException {
	private static final long serialVersionUID = 2954737147205046563L;

	public ApiEndpointException(String msg) {
		super(msg);
	}

}
