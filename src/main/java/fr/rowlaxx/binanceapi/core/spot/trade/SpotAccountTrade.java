package fr.rowlaxx.binanceapi.core.spot.trade;

import fr.rowlaxx.binanceapi.core.spot.marketdata.SpotTrade;
import fr.rowlaxx.jsavon.annotations.JOValue;

import org.json.JSONObject;

public class SpotAccountTrade extends SpotTrade {
	private static final long serialVersionUID = -5483341101213361605L;
	
	//Variables
	private double commission;
	private String commissionAsset;
	private boolean isBuyer;
	private boolean isMaker;
	private int orderId;
	@JOValue(mandatory = false) private Integer orderListId;
	private String symbol;
	
	//Constructeurs
	public SpotAccountTrade(JSONObject json) {
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
	
	public final boolean isMaker() {
		return this.isMaker;
	}
	
	public final int getOrderId() {
		return this.orderId;
	}
	
	public final int getOrderListId() {
		return this.orderListId;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}