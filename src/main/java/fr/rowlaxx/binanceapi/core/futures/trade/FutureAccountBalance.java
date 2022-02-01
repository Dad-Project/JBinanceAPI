package fr.rowlaxx.binanceapi.core.futures.trade;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public abstract class FutureAccountBalance extends JsavonObject {
	private static final long serialVersionUID = -4380274588644731881L;
	
	//Variables
	private String accountAlias;
	private String asset;
	private double availableBalance;
	private double balance;
	private double crossUnPnl;
	private double crossWalletBalance;
	private long updateTime;
	
	//Constructeurs
	public FutureAccountBalance(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAccountAlias() {
		return this.accountAlias;
	}
	
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getAvailableBalance() {
		return this.availableBalance;
	}
	
	public final double getBalance() {
		return this.balance;
	}
	
	public final double getCrossUnPnl() {
		return this.crossUnPnl;
	}
	
	public final double getCrossWalletBalance() {
		return this.crossWalletBalance;
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}