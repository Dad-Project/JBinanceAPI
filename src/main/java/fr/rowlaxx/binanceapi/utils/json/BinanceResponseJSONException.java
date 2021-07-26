package fr.rowlaxx.binanceapi.utils.json;

import fr.rowlaxx.binanceapi.exception.BinanceException;

public class BinanceResponseJSONException extends BinanceException {
	private static final long serialVersionUID = -6796165609193883537L;

	//Constructeurs
	public BinanceResponseJSONException(String msg) {
		super(msg);
	}

}
