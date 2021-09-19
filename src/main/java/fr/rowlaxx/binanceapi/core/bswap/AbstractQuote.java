package fr.rowlaxx.binanceapi.core.bswap;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;

abstract class AbstractQuote extends JSavONObject {
	private static final long serialVersionUID = 7423377929078996586L;
	
	//Variables
	private String baseAsset;
	private int fee;
	private double price;
	private String quoteAsset;
	private double slippage;

	//Constructeurs
	public AbstractQuote(JSONObject json) {
		super(json);
	}

	//Getters
	public final String getBaseAsset() {
		return this.baseAsset;
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

	public final double getSlippage() {
		return this.slippage;
	}

}