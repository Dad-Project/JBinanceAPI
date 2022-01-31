package fr.rowlaxx.binanceapi.core.coinm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.futures.marketdata.AccountLongShortRatio;

public class CoinmLongShortAccountRatio extends AccountLongShortRatio {
	private static final long serialVersionUID = -6845319456270373031L;
	
	private String pair;

	public CoinmLongShortAccountRatio(JSONObject json) {
		super(json);
	}

	public final String getPair() {
		return pair;
	}

}
