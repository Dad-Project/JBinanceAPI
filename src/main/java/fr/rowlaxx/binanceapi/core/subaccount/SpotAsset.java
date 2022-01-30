package fr.rowlaxx.binanceapi.core.subaccount;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class SpotAsset extends JsavonObject {
	private static final long serialVersionUID = -7408480788983113547L;
	
	//Variables
	private String email;
	private double totalAsset;
	
	//Constructeurs
	public SpotAsset(JSONObject json) {
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