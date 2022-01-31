package fr.rowlaxx.binanceapi.core.coinm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.futures.marketdata.PositionLongShortRatio;

public class CoinmLongShortPositionRatio extends PositionLongShortRatio {
	private static final long serialVersionUID = 4085955305907954426L;

	private String pair;
	
	public CoinmLongShortPositionRatio(JSONObject json) {
		super(json);
	}

	public final String getPair() {
		return pair;
	}
}