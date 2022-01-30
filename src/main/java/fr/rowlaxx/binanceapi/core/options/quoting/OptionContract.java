package fr.rowlaxx.binanceapi.core.options.quoting;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class OptionContract extends JsavonObject {
	private static final long serialVersionUID = 3576080428835675889L;
	
	//Variables
	private String settleAsset, baseAsset, underlying, quoteAsset;
	private int id;
	
	//Constructeurs
	public OptionContract(JSONObject json) {
		super(json);
	}
	
	//Getters
	public String getBaseAsset() {
		return baseAsset;
	}
	
	public int getId() {
		return id;
	}
	
	public String getQuoteAsset() {
		return quoteAsset;
	}
	
	public String getSettleAsset() {
		return settleAsset;
	}
	
	public String getUnderlying() {
		return underlying;
	}
}
