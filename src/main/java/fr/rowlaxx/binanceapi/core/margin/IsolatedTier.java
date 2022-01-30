package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class IsolatedTier extends JsavonObject {
	private static final long serialVersionUID = 6736120295076996867L;

	private String symbol;
	private int tier;
	private int effectiveMultiple;
	private double initialRiskRatio;
	private double liquidationRiskRatio;
	private double baseAssetMaxBorrowable;
	private double quoteAssetMaxBorrowable;
	
	public IsolatedTier(JSONObject json) {
		super(json);
	}
	
	public double getBaseAssetMaxBorrowable() {
		return baseAssetMaxBorrowable;
	}
	
	public int getEffectiveMultiple() {
		return effectiveMultiple;
	}
	
	public double getInitialRiskRatio() {
		return initialRiskRatio;
	}
	
	public double getLiquidationRiskRatio() {
		return liquidationRiskRatio;
	}
	
	public double getQuoteAssetMaxBorrowable() {
		return quoteAssetMaxBorrowable;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public int getTier() {
		return tier;
	}
}
