package fr.rowlaxx.binanceapi.core.usdm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.TickerStatistics;

public class UsdmTickerStatistics extends TickerStatistics {
	private static final long serialVersionUID = 68876222633377713L;

	private double quoteVolume;
	
	public UsdmTickerStatistics(JSONObject json) {
		super(json);
	}
	
	public final double getQuoteVolume() {
		return quoteVolume;
	}

}
