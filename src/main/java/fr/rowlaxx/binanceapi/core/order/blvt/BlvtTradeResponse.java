package fr.rowlaxx.binanceapi.core.order.blvt;

import org.json.JSONObject;

abstract class BlvtTradeResponse extends BlvtTrade {
	private static final long serialVersionUID = -7024310745427081093L;

	//Variables
	private BlvtTradeStatus status;
	
	//Constructeurs
	public BlvtTradeResponse(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final BlvtTradeStatus getStatus() {
		return this.status;
	}
}