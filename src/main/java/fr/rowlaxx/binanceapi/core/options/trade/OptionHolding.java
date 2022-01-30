package fr.rowlaxx.binanceapi.core.options.trade;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class OptionHolding extends JsavonObject {
	private static final long serialVersionUID = 2955047268897343445L;
	
	//Variables
	private int autoReducePriority;
	private int entryPrice;
	private long expiryDate;
	private int leverage;
	private double markPrice;
	private double markValue;
	private double quantity;
	private int reducibleQty;
	private double ror;
	private String side;
	private int strikePrice;
	private String symbol;
	private double unrealizedPNL;
	
	//Constructeurs
	public OptionHolding(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getAutoReducePriority() {
		return this.autoReducePriority;
	}
	
	public final int getEntryPrice() {
		return this.entryPrice;
	}
	
	public final long getExpiryDate() {
		return this.expiryDate;
	}
	
	public final int getLeverage() {
		return this.leverage;
	}
	
	public final double getMarkPrice() {
		return this.markPrice;
	}
	
	public final double getMarkValue() {
		return this.markValue;
	}
	
	public final double getQuantity() {
		return this.quantity;
	}
	
	public final int getReducibleQty() {
		return this.reducibleQty;
	}
	
	public final double getRor() {
		return this.ror;
	}
	
	public final String getSide() {
		return this.side;
	}
	
	public final int getStrikePrice() {
		return this.strikePrice;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final double getUnrealizedPNL() {
		return this.unrealizedPNL;
	}
}