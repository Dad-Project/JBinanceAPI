package fr.rowlaxx.temp.marginaccounttrade.marginaccountnewoco;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class OrderReports extends JSavONObject {
	private static final long serialVersionUID = -752801285402664626L;
	
	//Variables
	private String clientOrderId;
	private double cummulativeQuoteQty;
	private double executedQty;
	private int orderId;
	private int orderListId;
	private double origQty;
	private double price;
	private String side;
	private String status;
	private double stopPrice;
	private String symbol;
	private String timeInForce;
	private long transactTime;
	private String type;
	
	//Constructeurs
	public OrderReports(JSONObject json) {
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
	
	public final int getOrderId() {
		return this.orderId;
	}
	
	public final int getOrderListId() {
		return this.orderListId;
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
	
	public final String getTimeInForce() {
		return this.timeInForce;
	}
	
	public final long getTransactTime() {
		return this.transactTime;
	}
	
	public final String getType() {
		return this.type;
	}
}