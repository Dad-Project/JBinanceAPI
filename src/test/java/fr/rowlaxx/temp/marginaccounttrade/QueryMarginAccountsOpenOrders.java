package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class QueryMarginAccountsOpenOrders extends JSavONObject {
	private static final long serialVersionUID = 4758801363334632640L;
	
	//Variables
	private String clientOrderId;
	private double cummulativeQuoteQty;
	private double executedQty;
	private double icebergQty;
	private boolean isIsolated;
	private boolean isWorking;
	private int orderId;
	private double origQty;
	private double price;
	private String side;
	private String status;
	private double stopPrice;
	private String symbol;
	private long time;
	private String timeInForce;
	private String type;
	private long updateTime;
	
	//Constructeurs
	public QueryMarginAccountsOpenOrders(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getClientOrderId() {
		return this.clientOrderId;
	}
	
	public final double getCummulativeQuoteQty() {
		return this.cummulativeQuoteQty;
	}
	
	public final double getExecutedQty() {
		return this.executedQty;
	}
	
	public final double getIcebergQty() {
		return this.icebergQty;
	}
	
	public final boolean isIsolated() {
		return this.isIsolated;
	}
	
	public final boolean isWorking() {
		return this.isWorking;
	}
	
	public final int getOrderId() {
		return this.orderId;
	}
	
	public final double getOrigQty() {
		return this.origQty;
	}
	
	public final double getPrice() {
		return this.price;
	}
	
	public final String getSide() {
		return this.side;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final double getStopPrice() {
		return this.stopPrice;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final long getTime() {
		return this.time;
	}
	
	public final String getTimeInForce() {
		return this.timeInForce;
	}
	
	public final String getType() {
		return this.type;
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}