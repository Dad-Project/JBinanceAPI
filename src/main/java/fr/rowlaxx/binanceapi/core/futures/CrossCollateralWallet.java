package fr.rowlaxx.binanceapi.core.futures;

import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class CrossCollateralWallet extends JsavonObject {
	private static final long serialVersionUID = 608297379902553732L;
	
	//Variables
	private String asset;
	private List<CrossCollateral> crossCollaterals;
	private int interestFreeLimit;
	private double totalBorrowed;
	private double totalCrossCollateral;
	private double totalInterest;
	
	//Constructeurs
	public CrossCollateralWallet(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final List<CrossCollateral> getCrossCollaterals() {
		return this.crossCollaterals;
	}
	
	public final int getInterestFreeLimit() {
		return this.interestFreeLimit;
	}
	
	public final double getTotalBorrowed() {
		return this.totalBorrowed;
	}
	
	public final double getTotalCrossCollateral() {
		return this.totalCrossCollateral;
	}
	
	public final double getTotalInterest() {
		return this.totalInterest;
	}
}