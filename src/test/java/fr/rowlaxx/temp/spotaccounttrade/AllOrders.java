package fr.rowlaxx.temp.spotaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class AllOrders extends JSavONObject {
	private static final long serialVersionUID = 3685846334092118810L;
	
	//Variables
	private String clientOrderId;
	private double cummulativeQuoteQty;
	private double executedQty;
	private double icebergQty;
	private boolean isWorking;
	private int orderId;
	private int orderListId;
	private double origQty;
	private double origQuoteOrderQty;
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
	public AllOrders(JSONObject json) {
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
	
	public final boolean isWorking() {
		return this.isWorking;
	}
	
	public final int getOrderId() {
		return this.orderId;
	}
	
	public final int getOrderListId() {
		return this.orderListId;
	}
	
	public final double getOrigQty() {
		return this.origQty;
	}
	
	public final double getOrigQuoteOrderQty() {
		return this.origQuoteOrderQty;
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