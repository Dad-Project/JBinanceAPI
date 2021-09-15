package fr.rowlaxx.temp.blvtendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class RedeemBLVT extends JSavONObject {
	private static final long serialVersionUID = 1168056846971310548L;
	
	//Variables
	private double amount;
	private int id;
	private double redeemAmount;
	private String status;
	private long timestamp;
	private String tokenName;
	
	//Constructeurs
	public RedeemBLVT(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final int getId() {
		return this.id;
	}
	
	public final double getRedeemAmount() {
		return this.redeemAmount;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final long getTimestamp() {
		return this.timestamp;
	}
	
	public final String getTokenName() {
		return this.tokenName;
	}
}