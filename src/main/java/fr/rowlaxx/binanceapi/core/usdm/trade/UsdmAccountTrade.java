package fr.rowlaxx.binanceapi.core.usdm.trade;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.futures.trade.FutureAccountTrade;

public class UsdmAccountTrade extends FutureAccountTrade {
	private static final long serialVersionUID = 9019521640803828806L;

	private double quoteQty;
	
	public UsdmAccountTrade(JSONObject json) {
		super(json);
	}
	
	public final double getQuoteQty() {
		return quoteQty;
	}
}
