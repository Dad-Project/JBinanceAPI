package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class PositionRisk extends JSavONObject {
	private static final long serialVersionUID = 2745264099536024282L;
	
	//Variables
	private double entryPrice;
	private int leverage;
	private double liquidationPrice;
	private double markPrice;
	private int maxNotional;
	private double positionAmount;
	private String symbol;
	private double unrealizedProfit;
	
	//Constructeurs
	public PositionRisk(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getEntryPrice() {
		return this.entryPrice;
	}
	
	public final int getLeverage() {
		return this.leverage;
	}
	
	public final double getLiquidationPrice() {
		return this.liquidationPrice;
	}
	
	public final double getMarkPrice() {
		return this.markPrice;
	}
	
	public final int getMaxNotional() {
		return this.maxNotional;
	}
	
	public final double getPositionAmount() {
		return this.positionAmount;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final double getUnrealizedProfit() {
		return this.unrealizedProfit;
	}
}