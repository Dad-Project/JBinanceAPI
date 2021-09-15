package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class FundingWallet extends JSavONObject {
	private static final long serialVersionUID = -2635358054781207396L;
	
	//Variables
	private String asset;
	private double btcValuation;
	private int free;
	private int freeze;
	private int locked;
	private int withdrawing;
	
	//Constructeurs
	public FundingWallet(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getBtcValuation() {
		return this.btcValuation;
	}
	
	public final int getFree() {
		return this.free;
	}
	
	public final int getFreeze() {
		return this.freeze;
	}
	
	public final int getLocked() {
		return this.locked;
	}
	
	public final int getWithdrawing() {
		return this.withdrawing;
	}
}