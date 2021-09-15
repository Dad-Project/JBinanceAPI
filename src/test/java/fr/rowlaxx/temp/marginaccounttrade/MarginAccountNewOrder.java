package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class MarginAccountNewOrder extends JSavONObject {
	private static final long serialVersionUID = -8031990049136103773L;
	
	//Variables
	private String clientOrderId;
	private boolean isIsolated;
	private int orderId;
	private String symbol;
	private long transactTime;
	
	//Constructeurs
	public MarginAccountNewOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getClientOrderId() {
		return this.clientOrderId;
	}
	
	public final boolean isIsolated() {
		return this.isIsolated;
	}
	
	public final int getOrderId() {
		return this.orderId;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final long getTransactTime() {
		return this.transactTime;
	}
}