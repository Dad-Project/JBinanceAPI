package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.Asset;

public class FundingWallet extends Asset {
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