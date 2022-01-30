package fr.rowlaxx.binanceapi.core;

import org.json.JSONObject;

public class UserAsset extends Asset {
	private static final long serialVersionUID = -7794836890023245527L;

	//Variables
	private double borrowed; 
	private double interest; 
	private double netAsset;
	
	//Constructeurs
	public UserAsset(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getInterest() {
		return this.interest;
	}
	
	public final double getNetAsset() {
		return this.netAsset;
	}
	
	public final double getBorrowed() {
		return this.borrowed;
	}
}
