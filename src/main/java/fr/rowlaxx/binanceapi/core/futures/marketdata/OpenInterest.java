package fr.rowlaxx.binanceapi.core.futures.marketdata;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class OpenInterest extends JsavonObject {
	private static final long serialVersionUID = 7149810998832629854L;
	
	//Variables
	private double openInterest;
	private String symbol;
	private long time;
	
	//Constructeurs
	public OpenInterest(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getOpenInterest() {
		return this.openInterest;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final long getTime() {
		return this.time;
	}
}