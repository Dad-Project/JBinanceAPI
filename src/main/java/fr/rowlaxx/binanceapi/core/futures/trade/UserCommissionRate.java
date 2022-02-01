package fr.rowlaxx.binanceapi.core.futures.trade;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class UserCommissionRate extends JsavonObject {
	private static final long serialVersionUID = -4679006262619240884L;
	
	//Variables
	private double makerCommissionRate;
	private String symbol;
	private double takerCommissionRate;
	
	//Constructeurs
	public UserCommissionRate(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getMakerCommissionRate() {
		return this.makerCommissionRate;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final double getTakerCommissionRate() {
		return this.takerCommissionRate;
	}
}