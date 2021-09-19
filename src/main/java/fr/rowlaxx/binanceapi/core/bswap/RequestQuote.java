package fr.rowlaxx.binanceapi.core.bswap;

import org.json.JSONObject;

public class RequestQuote extends AbstractQuote {
	private static final long serialVersionUID = 6165908770555428839L;
	
	//Variables
	private int baseQty;
	private int quoteQty;
	
	//Constructeurs
	public RequestQuote(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getBaseQty() {
		return this.baseQty;
	}
	
	public final int getQuoteQty() {
		return this.quoteQty;
	}
}