package fr.rowlaxx.temp.walletendpoints.dailyaccountsnapshot2.snapshotvos.data;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Assets extends JSavONObject {
	private static final long serialVersionUID = -1699547811207275051L;
	
	//Variables
	private String asset;
	private double marginBalance;
	private double walletBalance;
	
	//Constructeurs
	public Assets(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getMarginBalance() {
		return this.marginBalance;
	}
	
	public final double getWalletBalance() {
		return this.walletBalance;
	}
}