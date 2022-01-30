package fr.rowlaxx.binanceapi.core;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class SymbolPriceTicker extends JsavonObject {
	private static final long serialVersionUID = -2096759154175062669L;
	
	//Variables
	private double price;
	private String symbol;
	
	//Constructeurs
	public SymbolPriceTicker(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getPrice() {
		return this.price;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}