package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class GetAllCrossMarginPairs extends JSavONObject {
	private static final long serialVersionUID = 3123400272202715686L;
	
	//Variables
	private String base;
	private long id;
	private boolean isBuyAllowed;
	private boolean isMarginTrade;
	private boolean isSellAllowed;
	private String quote;
	private String symbol;
	
	//Constructeurs
	public GetAllCrossMarginPairs(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getBase() {
		return this.base;
	}
	
	public final long getId() {
		return this.id;
	}
	
	public final boolean isBuyAllowed() {
		return this.isBuyAllowed;
	}
	
	public final boolean isMarginTrade() {
		return this.isMarginTrade;
	}
	
	public final boolean isSellAllowed() {
		return this.isSellAllowed;
	}
	
	public final String getQuote() {
		return this.quote;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}