package fr.rowlaxx.binanceapi.core.futures.trade;

import fr.rowlaxx.binanceapi.core.OrderSides;
import fr.rowlaxx.binanceapi.core.Trade;

import org.json.JSONObject;

public abstract class FutureAccountTrade extends Trade {
	private static final long serialVersionUID = 4721701320088000009L;
	
	//Variables
	private boolean buyer;
	private double commission;
	private String commissionAsset;
	private boolean maker;
	private long orderId;
	private PositionSides positionSide;
	private double realizedPnl;
	private OrderSides side;
	private String symbol;
	
	//Constructeurs
	public FutureAccountTrade(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final boolean isBuyer() {
		return this.buyer;
	}
	
	public final double getCommission() {
		return this.commission;
	}
	
	public final String getCommissionAsset() {
		return this.commissionAsset;
	}
	
	public final boolean isMaker() {
		return this.maker;
	}
	
	public final long getOrderId() {
		return this.orderId;
	}
	
	public final PositionSides getPositionSide() {
		return this.positionSide;
	}
	
	public final double getRealizedPnl() {
		return this.realizedPnl;
	}
	
	public final OrderSides getSide() {
		return this.side;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}