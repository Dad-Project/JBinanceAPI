package fr.rowlaxx.binanceapi.core.coinm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.SideableTrade;

public class CoinmTrade extends SideableTrade {
	private static final long serialVersionUID = -8087849406891656991L;

	private double baseQty;
	
	public CoinmTrade(JSONObject json) {
		super(json);
	}
	
	public final double getBaseQty() {
		return baseQty;
	}
}
