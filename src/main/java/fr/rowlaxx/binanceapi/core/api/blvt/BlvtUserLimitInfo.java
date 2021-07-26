package fr.rowlaxx.binanceapi.core.api.blvt;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class BlvtUserLimitInfo extends BinanceResponseJSON {
	private static final long serialVersionUID = 7961296371137282921L;

	//Variables
	@JsonValue private String tokenName;
	@JsonValue private double userDailyTotalPurchaseLimit;
	@JsonValue private double userDailyTotalRedeemLimit;
	
	//Constructeurs
	public BlvtUserLimitInfo(JSONObject response) {
		super(response);
	}
	
	//Getters
	public String getTokenName() {
		return tokenName;
	}
	
	public double getUserDailyTotalPurchaseLimit() {
		return userDailyTotalPurchaseLimit;
	}
	
	public double getUserDailyTotalRedeemLimit() {
		return userDailyTotalRedeemLimit;
	}
}
