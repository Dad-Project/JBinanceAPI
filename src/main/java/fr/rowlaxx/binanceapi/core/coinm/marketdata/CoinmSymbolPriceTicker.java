package fr.rowlaxx.binanceapi.core.coinm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.SymbolPriceTicker;

public class CoinmSymbolPriceTicker extends SymbolPriceTicker {
	private static final long serialVersionUID = -2092713189071626959L;

	private double ps;
	
	public CoinmSymbolPriceTicker(JSONObject json) {
		super(json);
	}
	
	public double getPs() {
		return ps;
	}
}
