package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class GetCollateralRepayQuote extends JSavONObject {
	private static final long serialVersionUID = 560272868947843889L;
	
	//Variables
	private double amount;
	private String coin;
	private String collateralCoin;
	private String quoteId;
	
	//Constructeurs
	public GetCollateralRepayQuote(JSONObject json) {
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