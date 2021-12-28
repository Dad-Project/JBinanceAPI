package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class Balance extends JsavonObject {
	private static final long serialVersionUID = -8246393742905404438L;
	
	//Variables
	private String asset;
	private double free;
	private double locked;
	
	//Constructeurs
	public Balance(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getFree() {
		return this.free;
	}
	
	public final double getLocked() {
		return this.locked;
	}
}