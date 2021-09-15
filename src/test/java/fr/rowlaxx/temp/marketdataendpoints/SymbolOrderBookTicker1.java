package fr.rowlaxx.temp.marketdataendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SymbolOrderBookTicker1 extends JSavONObject {
	private static final long serialVersionUID = 2388144113954430431L;
	
	//Variables
	private double askPrice;
	private double askQty;
	private double bidPrice;
	private double bidQty;
	private String symbol;
	
	//Constructeurs
	public SymbolOrderBookTicker1(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAskPrice() {
		return this.askPrice;
	}
	
	public final double getAskQty() {
		return this.askQty;
	}
	
	public final double getBidPrice() {
		return this.bidPrice;
	}
	
	public final double getBidQty() {
		return this.bidQty;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}