package fr.rowlaxx.binanceapi.core.usdm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.futures.marketdata.OpenInterestStatistics;

public class UsdmOpenInterestStatistics extends OpenInterestStatistics {
	private static final long serialVersionUID = -1335855950790727731L;

	private String symbol;
	
	public UsdmOpenInterestStatistics(JSONObject json) {
		super(json);
	}
	
	public final String getSymbol() {
		return symbol;
	}

}
