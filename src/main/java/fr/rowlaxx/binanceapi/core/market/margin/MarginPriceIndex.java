package fr.rowlaxx.binanceapi.core.market.margin;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class MarginPriceIndex extends JsavonObject {
	private static final long serialVersionUID = 2490542383016227502L;
	
	//Variables
	private long calcTime;
	private double price;
	private String symbol;
	
	//Constructeurs
	public MarginPriceIndex(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getCalcTime() {
		return this.calcTime;
	}
	
	public final double getPrice() {
		return this.price;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}