package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class ForceLiquidationRecord extends JsavonObject {
	private static final long serialVersionUID = 4488410859688809636L;
	
	//Variables
	private double avgPrice;
	private double executedQty;
	private boolean isIsolated;
	private int orderId;
	private double price;
	private double qty;
	private String side;
	private String symbol;
	private String timeInForce;
	private long updatedTime;
	
	//Constructeurs
	public ForceLiquidationRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAvgPrice() {
		return this.avgPrice;
	}
	
	public final double getExecutedQty() {
		return this.executedQty;
	}
	
	public final boolean isIsolated() {
		return this.isIsolated;
	}
	
	public final int getOrderId() {
		return this.orderId;
	}
	
	public final double getPrice() {
		return this.price;
	}
	
	public final double getQty() {
		return this.qty;
	}
	
	public final String getSide() {
		return this.side;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final String getTimeInForce() {
		return this.timeInForce;
	}
	
	public final long getUpdatedTime() {
		return this.updatedTime;
	}
}