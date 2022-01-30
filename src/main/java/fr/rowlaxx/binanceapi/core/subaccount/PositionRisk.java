package fr.rowlaxx.binanceapi.core.subaccount;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class PositionRisk extends JsavonObject {
	private static final long serialVersionUID = 2745264099536024282L;
	
	//Variables
	private double entryPrice;
	private int leverage;
	@JOValue(mandatory = false) private Double liquidationPrice;
	private double markPrice;
	@JOValue(mandatory = false) private Integer maxNotional;
	private double positionAmount;
	private String symbol;
	private double unrealizedProfit;
	@JOValue(mandatory = false) private Boolean isolated;
	@JOValue(mandatory = false) private Double isolatedWallet;
	@JOValue(mandatory = false) private Double isolatedMargin;
	@JOValue(mandatory = false) private Boolean isAutoAddMargin;
	@JOValue(mandatory = false) private String positionSide;
	
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
	
	public final Boolean isAutoAddMargin() {
		return isAutoAddMargin;
	}
	
	public final Double getIsolatedMargin() {
		return isolatedMargin;
	}
	
	public final Boolean isIsolated() {
		return isolated;
	}
	
	public final Double getIsolatedWallet() {
		return isolatedWallet;
	}
	
	public final String getPositionSide() {
		return positionSide;
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