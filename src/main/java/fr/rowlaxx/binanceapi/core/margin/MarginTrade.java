package fr.rowlaxx.binanceapi.core.margin;

import fr.rowlaxx.binanceapi.core.Trade;

import org.json.JSONObject;

public class MarginTrade extends Trade {
	private static final long serialVersionUID = -1427163229894164590L;
	
	//Variables
	private double commission;
	private String commissionAsset;
	private boolean isBuyer;
	private boolean isIsolated;
	private boolean isMaker;
	private int orderId;
	private String symbol;
	
	//Constructeurs
	public MarginTrade(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getCommission() {
		return this.commission;
	}
	
	public final String getCommissionAsset() {
		return this.commissionAsset;
	}
	
	public final boolean isBuyer() {
		return this.isBuyer;
	}
	
	public final boolean isIsolated() {
		return this.isIsolated;
	}
	
	public final boolean isMaker() {
		return this.isMaker;
	}
	
	public final int getOrderId() {
		return this.orderId;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}