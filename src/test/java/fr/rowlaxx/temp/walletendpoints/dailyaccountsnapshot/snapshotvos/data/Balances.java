package fr.rowlaxx.temp.walletendpoints.dailyaccountsnapshot.snapshotvos.data;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Balances extends JSavONObject {
	private static final long serialVersionUID = -8246393742905404438L;
	
	//Variables
	private String asset;
	private double free;
	private double locked;
	
	//Constructeurs
	public Balances(JSONObject json) {
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