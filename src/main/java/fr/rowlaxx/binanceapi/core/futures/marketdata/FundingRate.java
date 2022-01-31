package fr.rowlaxx.binanceapi.core.futures.marketdata;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class FundingRate extends JsavonObject {
	private static final long serialVersionUID = 2800204842078678946L;
	
	//Variables
	private double fundingRate;
	private long fundingTime;
	private String symbol;
	
	//Constructeurs
	public FundingRate(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getFundingRate() {
		return this.fundingRate;
	}
	
	public final long getFundingTime() {
		return this.fundingTime;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}