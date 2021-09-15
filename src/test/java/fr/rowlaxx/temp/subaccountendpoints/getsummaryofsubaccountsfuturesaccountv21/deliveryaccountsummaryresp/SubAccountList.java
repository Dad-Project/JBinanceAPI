package fr.rowlaxx.temp.subaccountendpoints.getsummaryofsubaccountsfuturesaccountv21.deliveryaccountsummaryresp;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SubAccountList extends JSavONObject {
	private static final long serialVersionUID = -2259804928232207266L;
	
	//Variables
	private String asset;
	private String email;
	private double totalMarginBalance;
	private double totalUnrealizedProfit;
	private double totalWalletBalance;
	
	//Constructeurs
	public SubAccountList(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final String getEmail() {
		return this.email;
	}
	
	public final double getTotalMarginBalance() {
		return this.totalMarginBalance;
	}
	
	public final double getTotalUnrealizedProfit() {
		return this.totalUnrealizedProfit;
	}
	
	public final double getTotalWalletBalance() {
		return this.totalWalletBalance;
	}
}