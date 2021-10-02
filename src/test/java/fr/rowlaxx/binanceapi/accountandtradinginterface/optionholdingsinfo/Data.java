package fr.rowlaxx.temp.accountandtradinginterface.optionholdingsinfo;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = -6482546621892842387L;
	
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
	public Data(JSONObject json) {
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