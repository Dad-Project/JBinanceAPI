package fr.rowlaxx.binanceapi.core.order.blvt;

import org.json.JSONObject;

public class RedemptionRecord extends BlvtTradeRecord {
	private static final long serialVersionUID = -9132339903872967879L;

	//Variables
	private double netProceed;
	
	//Constructeurs
	public RedemptionRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getNetProceed() {
		return this.netProceed;
	}

}
