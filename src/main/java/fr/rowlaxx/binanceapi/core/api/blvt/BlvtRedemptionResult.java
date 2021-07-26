package fr.rowlaxx.binanceapi.core.api.blvt;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class BlvtRedemptionResult extends BlvtTradeResult {
	private static final long serialVersionUID = -977622131449070358L;

	//Variables
	@JsonValue private double redeemAmount;
	
	//Constructeurs
	public BlvtRedemptionResult(JSONObject response) {
		super(response);
	}

	//Getters
	public double getRedeemAmount() {
		return redeemAmount;
	}
}