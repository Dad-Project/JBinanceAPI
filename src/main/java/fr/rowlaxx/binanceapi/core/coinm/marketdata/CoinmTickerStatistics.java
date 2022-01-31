package fr.rowlaxx.binanceapi.core.coinm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.TickerStatistics;

public abstract class CoinmTickerStatistics extends TickerStatistics {
	private static final long serialVersionUID = -5368170488593113954L;

	private String pair;
	private double baseVolume;
	
	public CoinmTickerStatistics(JSONObject json) {
		super(json);
	}
	
	public final double getBaseVolume() {
		return baseVolume;
	}
	
	public final String getPair() {
		return pair;
	}

}
