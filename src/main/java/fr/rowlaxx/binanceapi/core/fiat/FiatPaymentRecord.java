package fr.rowlaxx.binanceapi.core.fiat;

import org.json.JSONObject;

public class FiatPaymentRecord extends FiatTransfer {
	private static final long serialVersionUID = 4117718712797747189L;
	
	//Variables
	private String cryptoCurrency;
	private double obtainAmount;
	private double price;
	private double sourceAmount;
	
	//Constructeurs
	public FiatPaymentRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getCryptoCurrency() {
		return this.cryptoCurrency;
	}
	
	public final double getObtainAmount() {
		return this.obtainAmount;
	}
	
	public final double getPrice() {
		return this.price;
	}
	
	public final double getSourceAmount() {
		return this.sourceAmount;
	}
}