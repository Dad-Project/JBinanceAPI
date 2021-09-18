package fr.rowlaxx.binanceapi.core.future;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CrossCollateralInterestRecord extends JSavONObject {
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
	public CrossCollateralInterestRecord(JSONObject json) {
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