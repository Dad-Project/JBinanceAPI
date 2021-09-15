package fr.rowlaxx.temp.blvtendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SubscribeBLVT extends JSavONObject {
	private static final long serialVersionUID = -8113383206439744L;
	
	//Variables
	private double amount;
	private double cost;
	private int id;
	private String status;
	private long timestamp;
	private String tokenName;
	
	//Constructeurs
	public SubscribeBLVT(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final double getCost() {
		return this.cost;
	}
	
	public final int getId() {
		return this.id;
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