package fr.rowlaxx.binanceapi.core.spot.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.SideableTrade;

public class SpotTrade extends SideableTrade {
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