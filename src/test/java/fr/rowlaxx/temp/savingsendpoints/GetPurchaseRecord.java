package fr.rowlaxx.temp.savingsendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class GetPurchaseRecord extends JSavONObject {
	private static final long serialVersionUID = 1941507867703022230L;
	
	//Variables
	private double amount;
	private String asset;
	private long createTime;
	private String lendingType;
	private String productName;
	private int purchaseId;
	private String status;
	
	//Constructeurs
	public GetPurchaseRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getAsset() {
		return this.asset;
	}
	
	public final long getCreateTime() {
		return this.createTime;
	}
	
	public final String getLendingType() {
		return this.lendingType;
	}
	
	public final String getProductName() {
		return this.productName;
	}
	
	public final int getPurchaseId() {
		return this.purchaseId;
	}
	
	public final String getStatus() {
		return this.status;
	}
}