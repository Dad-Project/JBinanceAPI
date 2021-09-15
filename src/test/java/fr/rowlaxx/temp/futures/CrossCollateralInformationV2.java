package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CrossCollateralInformationV2 extends JSavONObject {
	private static final long serialVersionUID = -7215370812697379318L;
	
	//Variables
	private String collateralCoin;
	private double currentCollateralRate;
	private int interestGracePeriod;
	private double interestRate;
	private double liquidationCollateralRate;
	private String loanCoin;
	private double marginCallCollateralRate;
	private double rate;
	
	//Constructeurs
	public CrossCollateralInformationV2(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final double getCurrentCollateralRate() {
		return this.currentCollateralRate;
	}
	
	public final int getInterestGracePeriod() {
		return this.interestGracePeriod;
	}
	
	public final double getInterestRate() {
		return this.interestRate;
	}
	
	public final double getLiquidationCollateralRate() {
		return this.liquidationCollateralRate;
	}
	
	public final String getLoanCoin() {
		return this.loanCoin;
	}
	
	public final double getMarginCallCollateralRate() {
		return this.marginCallCollateralRate;
	}
	
	public final double getRate() {
		return this.rate;
	}
}