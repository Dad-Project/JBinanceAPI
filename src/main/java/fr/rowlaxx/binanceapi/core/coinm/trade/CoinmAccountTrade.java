package fr.rowlaxx.binanceapi.core.coinm.trade;

import fr.rowlaxx.binanceapi.core.futures.trade.FutureAccountTrade;

import org.json.JSONObject;

public class CoinmAccountTrade extends FutureAccountTrade {
	private static final long serialVersionUID = 1035784337305503446L;
	
	//Variables
	private double baseQty;
	private String marginAsset;
	private String pair;
	
	//Constructeurs
	public CoinmAccountTrade(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getMarginAsset() {
		return this.marginAsset;
	}
	
	public final String getPair() {
		return this.pair;
	}
	
	public final double getBaseQty() {
		return baseQty;
	}
}