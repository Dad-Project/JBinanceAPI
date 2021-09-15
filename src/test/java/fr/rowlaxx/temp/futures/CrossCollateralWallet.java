package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.futures.crosscollateralwallet.CrossCollaterals;

import java.util.List;

import org.json.JSONObject;

public class CrossCollateralWallet extends JSavONObject {
	private static final long serialVersionUID = 608297379902553732L;
	
	//Variables
	private String asset;
	private List<CrossCollaterals> crossCollaterals;
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
	
	public final List<CrossCollaterals> getCrossCollaterals() {
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