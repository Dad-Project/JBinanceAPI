package fr.rowlaxx.binanceapi.core.order.blvt;

import org.json.JSONObject;

abstract class BlvtTradeRecord extends BlvtTrade {
	private static final long serialVersionUID = 3536947889599077905L;

	//Variables
	private double nav;
	private double fee;
	
	//Constructeurs
	public BlvtTradeRecord(JSONObject json) {
		super(json);
	}

	//Getters
	public final double getFee() {
		return this.fee;
	}
	
	public final double getNav() {
		return this.nav;
	}
	
}
