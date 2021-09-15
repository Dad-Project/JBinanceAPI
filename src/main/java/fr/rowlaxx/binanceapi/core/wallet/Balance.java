package fr.rowlaxx.binanceapi.core.wallet;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Balance extends JSavONObject {
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