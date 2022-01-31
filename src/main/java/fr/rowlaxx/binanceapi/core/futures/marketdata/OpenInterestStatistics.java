package fr.rowlaxx.binanceapi.core.futures.marketdata;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public abstract class OpenInterestStatistics extends JsavonObject {
	private static final long serialVersionUID = -4963549363210504657L;
	
	//Variables
	private double sumOpenInterest;
	private double sumOpenInterestValue;
	private long timestamp;
	
	//Constructeurs
	public OpenInterestStatistics(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getSumOpenInterest() {
		return this.sumOpenInterest;
	}
	
	public final double getSumOpenInterestValue() {
		return this.sumOpenInterestValue;
	}
	
	public final long getTimestamp() {
		return this.timestamp;
	}
}