package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class QueryCrossMarginPair extends JSavONObject {
	private static final long serialVersionUID = 4287663740474370793L;
	
	//Variables
	private String base;
	private long id;
	private boolean isBuyAllowed;
	private boolean isMarginTrade;
	private boolean isSellAllowed;
	private String quote;
	private String symbol;
	
	//Constructeurs
	public QueryCrossMarginPair(JSONObject json) {
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