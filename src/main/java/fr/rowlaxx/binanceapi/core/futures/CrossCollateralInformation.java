package fr.rowlaxx.binanceapi.core.futures;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class CrossCollateralInformation extends JsavonObject {
	private static final long serialVersionUID = -7215370812697379318L;
	
	//Variables
	private String collateralCoin;
	private double currentCollateralRate;
	private int interestGracePeriod;
	private double interestRate;
	private double liquidationCollateralRate;
	@JOValue(mandatory = false)
	private String loanCoin;
	private double marginCallCollateralRate;
	private double rate;
	
	//Constructeurs
	public CrossCollateralInformation(JSONObject json) {
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