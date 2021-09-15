package fr.rowlaxx.temp.walletendpoints.assetdividendrecord;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Rows extends JSavONObject {
	private static final long serialVersionUID = 1361082148735487294L;
	
	//Variables
	private double amount;
	private String asset;
	private long divTime;
	private String enInfo;
	private long tranId;
	
	//Constructeurs
	public Rows(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getAsset() {
		return this.asset;
	}
	
	public final long getDivTime() {
		return this.divTime;
	}
	
	public final String getEnInfo() {
		return this.enInfo;
	}
	
	public final long getTranId() {
		return this.tranId;
	}
}