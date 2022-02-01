package fr.rowlaxx.binanceapi.core.coinm.trade;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.futures.trade.ForceOrder;

public class CoinmForceOrder extends ForceOrder {
	private static final long serialVersionUID = -6504481957365884285L;

	private String pair;
	private double cumBase;
	private boolean priceProtect;
	
	public CoinmForceOrder(JSONObject json) {
		super(json);
	}

	public final boolean isPriceProtect() {
		return priceProtect;
	}
	
	public final double getCumBase() {
		return cumBase;
	}
	
	public final String getPair() {
		return pair;
	}
	
}
