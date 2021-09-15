package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class QueryIsolatedMarginSymbol extends JSavONObject {
	private static final long serialVersionUID = 4571773304369949574L;
	
	//Variables
	private String base;
	private boolean isBuyAllowed;
	private boolean isMarginTrade;
	private boolean isSellAllowed;
	private String quote;
	private String symbol;
	
	//Constructeurs
	public QueryIsolatedMarginSymbol(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getBase() {
		return this.base;
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