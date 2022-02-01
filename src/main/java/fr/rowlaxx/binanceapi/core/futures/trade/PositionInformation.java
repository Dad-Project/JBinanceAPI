package fr.rowlaxx.binanceapi.core.futures.trade;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

import org.json.JSONObject;

public class PositionInformation extends JsavonObject {
	private static final long serialVersionUID = -2592769022003853021L;
	
	//Variables
	private double entryPrice;
	private boolean isAutoAddMargin;
	private double isolatedMargin;
	private int leverage;
	private double liquidationPrice;
	private String marginType;
	private double markPrice;
	@JOValue(key = {"maxNotionalValue", "maxQty"}) private long maxPosition;
	private double positionAmt;
	private PositionSides positionSide;
	private String symbol;
	private double unRealizedProfit;
	private int updateTime;
	
	//Constructeurs
	public PositionInformation(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getEntryPrice() {
		return this.entryPrice;
	}
	
	public final boolean isAutoAddMargin() {
		return this.isAutoAddMargin;
	}
	
	public final double getIsolatedMargin() {
		return this.isolatedMargin;
	}
	
	public final int getLeverage() {
		return this.leverage;
	}
	
	public final double getLiquidationPrice() {
		return this.liquidationPrice;
	}
	
	public final String getMarginType() {
		return this.marginType;
	}
	
	public final double getMarkPrice() {
		return this.markPrice;
	}
	
	public final long getMaxPosition() {
		return this.maxPosition;
	}
	
	public final double getPositionAmt() {
		return this.positionAmt;
	}
	
	public final PositionSides getPositionSide() {
		return this.positionSide;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final double getUnRealizedProfit() {
		return this.unRealizedProfit;
	}
	
	public final int getUpdateTime() {
		return this.updateTime;
	}
}