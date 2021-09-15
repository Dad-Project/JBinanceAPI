package fr.rowlaxx.temp.blvtendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class QuerySubscriptionRecord extends JSavONObject {
	private static final long serialVersionUID = 4234411911245866940L;
	
	//Variables
	private double amount;
	private double fee;
	private int id;
	private double nav;
	private long timestamp;
	private String tokenName;
	private double totalCharge;
	
	//Constructeurs
	public QuerySubscriptionRecord(JSONObject json) {
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
	
	public final long getTimestamp() {
		return this.timestamp;
	}
	
	public final String getTokenName() {
		return this.tokenName;
	}
	
	public final double getTotalCharge() {
		return this.totalCharge;
	}
}