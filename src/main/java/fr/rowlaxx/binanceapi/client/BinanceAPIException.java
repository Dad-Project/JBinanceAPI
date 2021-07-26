package fr.rowlaxx.binanceapi.client;

import fr.rowlaxx.binanceapi.exception.BinanceException;

public class BinanceAPIException extends BinanceException {
	private static final long serialVersionUID = 25661446321357741L;

	public BinanceAPIException(String msg) {
		super(msg);
	}
	
}
