package fr.rowlaxx.binanceapi.core.margin;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class IsolatedMarginSymbol extends JsavonObject {
	private static final long serialVersionUID = 4571773304369949574L;
	
	//Variables
	private String base;
	private boolean isBuyAllowed;
	private boolean isMarginTrade;
	private boolean isSellAllowed;
	private String quote;
	private String symbol;
	
	//Constructeurs
	public IsolatedMarginSymbol(JSONObject json) {
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