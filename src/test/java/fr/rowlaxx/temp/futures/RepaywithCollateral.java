package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class RepaywithCollateral extends JSavONObject {
	private static final long serialVersionUID = 1143586850625445974L;
	
	//Variables
	private int amount;
	private String coin;
	private String collateralCoin;
	private String quoteId;
	
	//Constructeurs
	public RepaywithCollateral(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getAmount() {
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