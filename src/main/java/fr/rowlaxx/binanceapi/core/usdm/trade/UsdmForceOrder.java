package fr.rowlaxx.binanceapi.core.usdm.trade;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.futures.trade.ForceOrder;

public class UsdmForceOrder extends ForceOrder {
	private static final long serialVersionUID = -7760499883594639834L;

	private double cumQuote;
	
	public UsdmForceOrder(JSONObject json) {
		super(json);
	}
	
	public final double getCumQuote() {
		return cumQuote;
	}
}
