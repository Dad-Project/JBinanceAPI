package fr.rowlaxx.temp.marginaccounttrade.queryrepayrecord;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Rows extends JSavONObject {
	private static final long serialVersionUID = -2983885789800198103L;
	
	//Variables
	private double amount;
	private String asset;
	private double interest;
	private String isolatedSymbol;
	private double principal;
	private String status;
	private long timestamp;
	private long txId;
	
	//Constructeurs
	public Rows(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getInterest() {
		return this.interest;
	}
	
	public final String getIsolatedSymbol() {
		return this.isolatedSymbol;
	}
	
	public final double getPrincipal() {
		return this.principal;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final long getTimestamp() {
		return this.timestamp;
	}
	
	public final long getTxId() {
		return this.txId;
	}
}