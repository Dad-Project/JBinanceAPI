package fr.rowlaxx.temp.blvtendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class GetBLVTUserLimitInfo extends JSavONObject {
	private static final long serialVersionUID = -2251796388307172118L;
	
	//Variables
	private String tokenName;
	private int userDailyTotalPurchaseLimit;
	private int userDailyTotalRedeemLimit;
	
	//Constructeurs
	public GetBLVTUserLimitInfo(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getTokenName() {
		return this.tokenName;
	}
	
	public final int getUserDailyTotalPurchaseLimit() {
		return this.userDailyTotalPurchaseLimit;
	}
	
	public final int getUserDailyTotalRedeemLimit() {
		return this.userDailyTotalRedeemLimit;
	}
}