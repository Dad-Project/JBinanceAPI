package fr.rowlaxx.binanceapi.core.blvt;

import org.json.JSONObject;

public class SubscriptionRecord extends BlvtTradeRecord {
	private static final long serialVersionUID = -82454539513053661L;
	
	//Variables
	private double totalCharge;
	
	//Constructeurs
	public SubscriptionRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getTotalCharge() {
		return this.totalCharge;
	}

}
