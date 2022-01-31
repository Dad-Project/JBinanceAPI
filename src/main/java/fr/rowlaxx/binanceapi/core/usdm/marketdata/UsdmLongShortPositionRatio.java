package fr.rowlaxx.binanceapi.core.usdm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.futures.marketdata.PositionLongShortRatio;

public class UsdmLongShortPositionRatio extends PositionLongShortRatio {
	private static final long serialVersionUID = 4085955305907954426L;

	private String symbol;
	
	public UsdmLongShortPositionRatio(JSONObject json) {
		super(json);
	}

	public final String getSymbol() {
		return symbol;
	}
}