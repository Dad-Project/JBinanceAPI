package fr.rowlaxx.temp.subaccountendpoints.getfuturespositionriskofsubaccountv21;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class DeliveryPositionRiskVos extends JSavONObject {
	private static final long serialVersionUID = -834751627758728748L;
	
	//Variables
	private double entryPrice;
	private boolean isAutoAddMargin;
	private boolean isolated;
	private double isolatedMargin;
	private double isolatedWallet;
	private int leverage;
	private double markPrice;
	private double positionAmount;
	private String positionSide;
	private String symbol;
	private double unrealizedProfit;
	
	//Constructeurs
	public DeliveryPositionRiskVos(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getEntryPrice() {
		return this.entryPrice;
	}
	
	public final boolean isAutoAddMargin() {
		return this.isAutoAddMargin;
	}
	
	public final boolean isOlated() {
		return this.isolated;
	}
	
	public final double getIsolatedMargin() {
		return this.isolatedMargin;
	}
	
	public final double getIsolatedWallet() {
		return this.isolatedWallet;
	}
	
	public final int getLeverage() {
		return this.leverage;
	}
	
	public final double getMarkPrice() {
		return this.markPrice;
	}
	
	public final double getPositionAmount() {
		return this.positionAmount;
	}
	
	public final String getPositionSide() {
		return this.positionSide;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final double getUnrealizedProfit() {
		return this.unrealizedProfit;
	}
}