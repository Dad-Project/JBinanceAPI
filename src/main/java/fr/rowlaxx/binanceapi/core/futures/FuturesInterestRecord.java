package fr.rowlaxx.binanceapi.core.futures;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class FuturesInterestRecord extends JsavonObject {
	private static final long serialVersionUID = -5696793126687215386L;
	
	//Variables
	private String collateralCoin;
	private double interest;
	private String interestCoin;
	private int interestFreeLimitUsed;
	private double interestRate;
	private int principalForInterest;
	private long time;
	
	//Constructeurs
	public FuturesInterestRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final double getInterest() {
		return this.interest;
	}
	
	public final String getInterestCoin() {
		return this.interestCoin;
	}
	
	public final int getInterestFreeLimitUsed() {
		return this.interestFreeLimitUsed;
	}
	
	public final double getInterestRate() {
		return this.interestRate;
	}
	
	public final int getPrincipalForInterest() {
		return this.principalForInterest;
	}
	
	public final long getTime() {
		return this.time;
	}
}