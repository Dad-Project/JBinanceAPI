package fr.rowlaxx.binanceapi.core.futures;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class RepayQuote extends JsavonObject {
	private static final long serialVersionUID = 560272868947843889L;
	
	//Variables
	private double amount;
	private String coin;
	private String collateralCoin;
	private String quoteId;
	
	//Constructeurs
	public RepayQuote(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final String getQuoteId() {
		return this.quoteId;
	}
}