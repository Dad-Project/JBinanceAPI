package fr.rowlaxx.binanceapi.core.blvt;

import org.json.JSONObject;

public class Redemption extends BlvtTradeResponse {
	private static final long serialVersionUID = 1168056846971310548L;
	
	//Variables
	private double redeemAmount;
	
	//Constructeurs
	public Redemption(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getRedeemAmount() {
		return this.redeemAmount;
	}
}