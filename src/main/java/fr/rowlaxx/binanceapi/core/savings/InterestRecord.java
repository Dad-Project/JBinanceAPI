package fr.rowlaxx.binanceapi.core.savings;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class InterestRecord extends JSavONObject {
	private static final long serialVersionUID = -5042757535970999556L;
	
	//Variables
	private String asset;
	private double interest;
	private String lendingType;
	private String productName;
	private long time;
	
	//Constructeurs
	public InterestRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getInterest() {
		return this.interest;
	}
	
	public final String getLendingType() {
		return this.lendingType;
	}
	
	public final String getProductName() {
		return this.productName;
	}
	
	public final long getTime() {
		return this.time;
	}
}