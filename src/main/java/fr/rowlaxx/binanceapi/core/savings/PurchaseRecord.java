package fr.rowlaxx.binanceapi.core.savings;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

import org.json.JSONObject;

public class PurchaseRecord extends JSavONObject {
	private static final long serialVersionUID = 1941507867703022230L;
	
	//Variables
	private double amount;
	private String asset;
	private long createTime;
	private LendingTypes lendingType;
	@JOValue(mandatory = false)
	private Double lot;
	private String productName;
	private int purchaseId;
	private String status;
	
	//Constructeurs
	public PurchaseRecord(JSONObject json) {
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
	
	public final LendingTypes getLendingType() {
		return this.lendingType;
	}
	
	public final Double getLot() {
		return this.lot;
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