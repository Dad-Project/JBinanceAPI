package fr.rowlaxx.temp.accountandtradinginterface.accountassetinfo;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = -75699716598864350L;
	
	//Variables
	private double available;
	private double balance;
	private String currency;
	private double equity;
	private double maintMargin;
	private double orderMargin;
	private double positionMargin;
	private double unrealizedPNL;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAvailable() {
		return this.available;
	}
	
	public final double getBalance() {
		return this.balance;
	}
	
	public final String getCurrency() {
		return this.currency;
	}
	
	public final double getEquity() {
		return this.equity;
	}
	
	public final double getMaintMargin() {
		return this.maintMargin;
	}
	
	public final double getOrderMargin() {
		return this.orderMargin;
	}
	
	public final double getPositionMargin() {
		return this.positionMargin;
	}
	
	public final double getUnrealizedPNL() {
		return this.unrealizedPNL;
	}
}