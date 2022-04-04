package fr.rowlaxx.binanceapi.core.coinm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.BookTicker;

public class CoinmOrderBookTicker extends BookTicker {
	private static final long serialVersionUID = 7479818087200748081L;

	private String pair;
	
	public CoinmOrderBookTicker(JSONObject json) {
		super(json);
	}
	
	public final String getPair() {
		return pair;
	}
}
