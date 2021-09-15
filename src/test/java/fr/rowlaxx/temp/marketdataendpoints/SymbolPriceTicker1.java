package fr.rowlaxx.temp.marketdataendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SymbolPriceTicker1 extends JSavONObject {
	private static final long serialVersionUID = -4416257128532670099L;
	
	//Variables
	private double price;
	private String symbol;
	
	//Constructeurs
	public SymbolPriceTicker1(JSONObject json) {
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