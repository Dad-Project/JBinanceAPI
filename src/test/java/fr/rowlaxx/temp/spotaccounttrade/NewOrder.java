package fr.rowlaxx.temp.spotaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class NewOrder extends JSavONObject {
	private static final long serialVersionUID = 5905710230232057126L;
	
	//Variables
	private String clientOrderId;
	private int orderId;
	private int orderListId;
	private String symbol;
	private long transactTime;
	
	//Constructeurs
	public NewOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getClientOrderId() {
		return this.clientOrderId;
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
	
	public final long getTransactTime() {
		return this.transactTime;
	}
}