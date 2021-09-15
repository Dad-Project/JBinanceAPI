package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SubUserSpotAsset extends JSavONObject {
	private static final long serialVersionUID = -7408480788983113547L;
	
	//Variables
	private String email;
	private double totalAsset;
	
	//Constructeurs
	public SubUserSpotAsset(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getEmail() {
		return this.email;
	}
	
	public final double getTotalAsset() {
		return this.totalAsset;
	}
}