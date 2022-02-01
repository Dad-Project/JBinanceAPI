package fr.rowlaxx.binanceapi.core.futures.trade;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public abstract class FutureAccountPosition extends JsavonObject {
	private static final long serialVersionUID = -8722260256710554612L;

	private PositionSides positionSide;
	private String symbol;
	private double unrealizedProfit;
	private long updateTime;
	private double openOrderInitialMargin;
	private double positionAmt;
	private double positionInitialMargin;
	private boolean isolated;
	private int leverage;
	private double maintMargin;
	private double entryPrice;
	private double initialMargin;
	
	public FutureAccountPosition(JSONObject json) {
		super(json);
	}
	
	public final double getEntryPrice() {
		return this.entryPrice;
	}
	
	public final double getInitialMargin() {
		return this.initialMargin;
	}
	
	public final boolean isIsolated() {
		return this.isolated;
	}
	
	public final double getOpenOrderInitialMargin() {
		return this.openOrderInitialMargin;
	}
	
	public final double getPositionAmt() {
		return this.positionAmt;
	}
	
	public final double getPositionInitialMargin() {
		return this.positionInitialMargin;
	}
	
	public final PositionSides getPositionSide() {
		return this.positionSide;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final double getUnrealizedProfit() {
		return this.unrealizedProfit;
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
	
	public final int getLeverage() {
		return this.leverage;
	}
	
	public final double getMaintMargin() {
		return this.maintMargin;
	}
	
}
