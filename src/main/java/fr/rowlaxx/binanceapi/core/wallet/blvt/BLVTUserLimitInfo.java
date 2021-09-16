package fr.rowlaxx.binanceapi.core.wallet.blvt;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class BLVTUserLimitInfo extends JSavONObject {
	private static final long serialVersionUID = -2251796388307172118L;
	
	//Variables
	private String tokenName;
	private double userDailyTotalPurchaseLimit;
	private double userDailyTotalRedeemLimit;
	
	//Constructeurs
	public BLVTUserLimitInfo(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getTokenName() {
		return this.tokenName;
	}
	
	public final double getUserDailyTotalPurchaseLimit() {
		return this.userDailyTotalPurchaseLimit;
	}
	
	public final double getUserDailyTotalRedeemLimit() {
		return this.userDailyTotalRedeemLimit;
	}
}