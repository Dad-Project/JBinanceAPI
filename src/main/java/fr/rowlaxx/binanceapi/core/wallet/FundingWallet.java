package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

public class FundingWallet extends Balance {
	private static final long serialVersionUID = -2635358054781207396L;
	
	//Variables
	private double btcValuation;
	private double freeze;
	private double withdrawing;
	
	//Constructeurs
	public FundingWallet(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getBtcValuation() {
		return this.btcValuation;
	}

	public final double getFreeze() {
		return this.freeze;
	}
	
	public final double getWithdrawing() {
		return this.withdrawing;
	}
}