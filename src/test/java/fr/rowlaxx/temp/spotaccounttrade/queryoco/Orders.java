package fr.rowlaxx.temp.spotaccounttrade.queryoco;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Orders extends JSavONObject {
	private static final long serialVersionUID = 8654391323640158597L;
	
	//Variables
	private String clientOrderId;
	private int orderId;
	private String symbol;
	
	//Constructeurs
	public Orders(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getClientOrderId() {
		return this.clientOrderId;
	}
	
	public final int getOrderId() {
		return this.orderId;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}