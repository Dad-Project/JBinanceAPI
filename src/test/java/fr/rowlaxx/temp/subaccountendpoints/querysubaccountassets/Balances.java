package fr.rowlaxx.temp.subaccountendpoints.querysubaccountassets;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Balances extends JSavONObject {
	private static final long serialVersionUID = -6193855773746242700L;
	
	//Variables
	private String asset;
	private int free;
	private int locked;
	
	//Constructeurs
	public Balances(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final int getFree() {
		return this.free;
	}
	
	public final int getLocked() {
		return this.locked;
	}
}