package fr.rowlaxx.temp.blvtendpoints.getblvtinfo;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CurrentBaskets extends JSavONObject {
	private static final long serialVersionUID = -8127523780594862991L;
	
	//Variables
	private double amount;
	private double notionalValue;
	private String symbol;
	
	//Constructeurs
	public CurrentBaskets(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final double getNotionalValue() {
		return this.notionalValue;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}