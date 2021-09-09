package fr.rowlaxx.binanceapi.core.general.options;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class OptionContract extends JSavONObject {
	private static final long serialVersionUID = 3576080428835675889L;
	
	//Variables
	@JOValue private String settleAsset, baseAsset, underlying, quoteAsset;
	@JOValue private int id;
	
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
