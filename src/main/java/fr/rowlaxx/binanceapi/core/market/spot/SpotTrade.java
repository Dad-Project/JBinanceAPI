package fr.rowlaxx.binanceapi.core.market.spot;

import org.json.JSONObject;

public class SpotTrade extends SpotAbstractTrade {
	private static final long serialVersionUID = -4504990920483257735L;
	
	//Variables
	private double quoteQty;
	
	//Constructeurs
	public SpotTrade(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getQuoteQty() {
		return this.quoteQty;
	}
}