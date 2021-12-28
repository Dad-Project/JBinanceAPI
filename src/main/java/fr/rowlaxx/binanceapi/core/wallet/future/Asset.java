package fr.rowlaxx.binanceapi.core.wallet.future;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class Asset extends JsavonObject {
	private static final long serialVersionUID = -1699547811207275051L;
	
	//Variables
	private String asset;
	private double marginBalance;
	private double walletBalance;
	
	//Constructeurs
	public Asset(JSONObject json) {
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