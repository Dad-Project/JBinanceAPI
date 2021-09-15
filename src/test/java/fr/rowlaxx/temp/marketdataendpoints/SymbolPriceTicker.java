package fr.rowlaxx.temp.marketdataendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SymbolPriceTicker extends JSavONObject {
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