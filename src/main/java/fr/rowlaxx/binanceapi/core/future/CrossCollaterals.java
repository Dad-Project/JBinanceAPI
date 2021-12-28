package fr.rowlaxx.binanceapi.core.future;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class CrossCollaterals extends JsavonObject {
	private static final long serialVersionUID = 8984844348351592086L;
	
	//Variables
	private String collateralCoin;
	private double currentCollateralRate;
	private double interest;
	private double interestFreeLimitUsed;
	private double loanAmount;
	@JOValue(mandatory = false)
	private String loanCoin;
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
	
	public final String getLoanCoin() {
		return this.loanCoin;
	}
	
	public final double getLocked() {
		return this.locked;
	}
	
	public final double getPrincipalForInterest() {
		return this.principalForInterest;
	}
}