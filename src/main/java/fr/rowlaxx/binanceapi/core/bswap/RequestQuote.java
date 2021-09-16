package fr.rowlaxx.binanceapi.core.bswap;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class RequestQuote extends JSavONObject {
	private static final long serialVersionUID = 6165908770555428839L;
	
	//Variables
	private String baseAsset;
	private int baseQty;
	private int fee;
	private double price;
	private String quoteAsset;
	private int quoteQty;
	private double slippage;
	
	//Constructeurs
	public RequestQuote(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getBaseAsset() {
		return this.baseAsset;
	}
	
	public final int getBaseQty() {
		return this.baseQty;
	}
	
	public final int getFee() {
		return this.fee;
	}
	
	public final double getPrice() {
		return this.price;
	}
	
	public final String getQuoteAsset() {
		return this.quoteAsset;
	}
	
	public final int getQuoteQty() {
		return this.quoteQty;
	}
	
	public final double getSlippage() {
		return this.slippage;
	}
}