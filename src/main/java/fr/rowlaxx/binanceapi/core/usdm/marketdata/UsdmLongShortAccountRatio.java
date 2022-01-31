package fr.rowlaxx.binanceapi.core.usdm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.futures.marketdata.AccountLongShortRatio;

public class UsdmLongShortAccountRatio extends AccountLongShortRatio {
	private static final long serialVersionUID = -6845319456270373031L;
	
	private String symbol;

	public UsdmLongShortAccountRatio(JSONObject json) {
		super(json);
	}

	public final String getSymbol() {
		return symbol;
	}
}
