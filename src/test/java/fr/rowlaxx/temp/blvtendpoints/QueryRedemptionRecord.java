package fr.rowlaxx.temp.blvtendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class QueryRedemptionRecord extends JSavONObject {
	private static final long serialVersionUID = 6006654191807789634L;
	
	//Variables
	private double amount;
	private double fee;
	private int id;
	private double nav;
	private double netProceed;
	private long timestamp;
	private String tokenName;
	
	//Constructeurs
	public QueryRedemptionRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final double getFee() {
		return this.fee;
	}
	
	public final int getId() {
		return this.id;
	}
	
	public final double getNav() {
		return this.nav;
	}
	
	public final double getNetProceed() {
		return this.netProceed;
	}
	
	public final long getTimestamp() {
		return this.timestamp;
	}
	
	public final String getTokenName() {
		return this.tokenName;
	}
}