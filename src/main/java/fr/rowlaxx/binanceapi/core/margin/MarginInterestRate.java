package fr.rowlaxx.binanceapi.core.margin;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class MarginInterestRate extends JsavonObject {
	private static final long serialVersionUID = 1064663157202373817L;
	
	//Variables
	private String asset;
	private double dailyInterestRate;
	private long timestamp;
	private int vipLevel;
	
	//Constructeurs
	public MarginInterestRate(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getDailyInterestRate() {
		return this.dailyInterestRate;
	}
	
	public final long getTimestamp() {
		return this.timestamp;
	}
	
	public final int getVipLevel() {
		return this.vipLevel;
	}
}