package fr.rowlaxx.binanceapi.client.http;

import fr.rowlaxx.binanceapi.exceptions.BinanceException;

public class BinanceHttpRequestException extends BinanceException {
	private static final long serialVersionUID = -7383415533103681805L;

	//Constructeurs
	public BinanceHttpRequestException(String msg) {
		super(msg);
	}

}
