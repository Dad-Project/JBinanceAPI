package fr.rowlaxx.binanceapi.core.blvt;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

abstract class BlvtTrade extends JsavonObject {
	private static final long serialVersionUID = -4004343023477677130L;

	//Variables
	private int id;
	private double amount;
	private long timestamp;
	private String tokenName;
	
	//Constructeurs
	public BlvtTrade(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getId() {
		return this.id;
	}
	
	public final long getTimestamp() {
		return this.timestamp;
	}
	
	public final String getTokenName() {
		return this.tokenName;
	}
	
	public final double getAmount() {
		return this.amount;
	}
}
