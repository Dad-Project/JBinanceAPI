package fr.rowlaxx.binanceapi.core.usdm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.SideableTrade;

public class UsdmTrade extends SideableTrade {
	private static final long serialVersionUID = -8087849406891656991L;

	private double quoteQty;
	
	public UsdmTrade(JSONObject json) {
		super(json);
	}
	
	public final double getQuoteQty() {
		return quoteQty;
	}
}
