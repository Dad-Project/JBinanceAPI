package fr.rowlaxx.binanceapi.client.http;

import fr.rowlaxx.binanceapi.exceptions.BinanceException;

public class ApiEndpointException extends BinanceException {
	private static final long serialVersionUID = 2954737147205046563L;

	public ApiEndpointException(String msg) {
		super(msg);
	}

}
