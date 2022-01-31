package fr.rowlaxx.binanceapi.core;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class SymbolPriceTicker extends JsavonObject {
	private static final long serialVersionUID = -2096759154175062669L;
	
	//Variables
	private double price;
	private String symbol;
	@JOValue(mandatory = false) private Long time;
	
	//Constructeurs
	public SymbolPriceTicker(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getPrice() {
		return this.price;
	}
	
	public final Long getTime() {
		return time;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}