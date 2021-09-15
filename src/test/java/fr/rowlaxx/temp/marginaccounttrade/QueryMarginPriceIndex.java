package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class QueryMarginPriceIndex extends JSavONObject {
	private static final long serialVersionUID = 2490542383016227502L;
	
	//Variables
	private long calcTime;
	private double price;
	private String symbol;
	
	//Constructeurs
	public QueryMarginPriceIndex(JSONObject json) {
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