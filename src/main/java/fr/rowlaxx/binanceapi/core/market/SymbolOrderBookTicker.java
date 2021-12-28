package fr.rowlaxx.binanceapi.core.market;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class SymbolOrderBookTicker extends JsavonObject {
	private static final long serialVersionUID = 6781128770211592070L;
	
	//Variables
	private double askPrice;
	private double askQty;
	private double bidPrice;
	private double bidQty;
	private String symbol;
	
	//Constructeurs
	public SymbolOrderBookTicker(JSONObject json) {
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