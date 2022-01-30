package fr.rowlaxx.binanceapi.core.blvt;

import org.json.JSONObject;

public class Subscribtion extends BlvtTradeResponse {
	private static final long serialVersionUID = -8113383206439744L;
	
	//Variables
	private double cost;
	
	//Constructeurs
	public Subscribtion(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getCost() {
		return this.cost;
	}
}