package fr.rowlaxx.temp.futures.crosscollateralwallet;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CrossCollaterals extends JSavONObject {
	private static final long serialVersionUID = 5648485973636840772L;
	
	//Variables
	private String collateralCoin;
	private double currentCollateralRate;
	private double interest;
	private double interestFreeLimitUsed;
	private double loanAmount;
	private double locked;
	private double principalForInterest;
	
	//Constructeurs
	public CrossCollaterals(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final double getCurrentCollateralRate() {
		return this.currentCollateralRate;
	}
	
	public final double getInterest() {
		return this.interest;
	}
	
	public final double getInterestFreeLimitUsed() {
		return this.interestFreeLimitUsed;
	}
	
	public final double getLoanAmount() {
		return this.loanAmount;
	}
	
	public final double getLocked() {
		return this.locked;
	}
	
	public final double getPrincipalForInterest() {
		return this.principalForInterest;
	}
}