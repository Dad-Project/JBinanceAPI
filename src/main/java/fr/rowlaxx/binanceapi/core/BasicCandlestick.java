package fr.rowlaxx.binanceapi.core;

import org.json.JSONArray;

import fr.rowlaxx.jsavon.JsavonArray;
import fr.rowlaxx.jsavon.annotations.JAValue;

public class BasicCandlestick extends JsavonArray implements Candlestick {
	private static final long serialVersionUID = -1885063134974002265L;
	
	//Variables
	@JAValue(index = 0) private long openTime;
	@JAValue(index = 1) private double open;
	@JAValue(index = 2) private double high;
	@JAValue(index = 3) private double low;
	@JAValue(index = 4) private double close;
	@JAValue(index = 5) private double volume;
	@JAValue(index = 6) private long closeTime;
	@JAValue(index = 7) private double quoteAssetVolume;
	@JAValue(index = 8) private int numberOfTrades;
	@JAValue(index = 9) private double takerBuyBaseAssetVolume;
	@JAValue(index = 10) private double takerBuyQuoteAssetVolume;
	
	//Constructeurs
	public BasicCandlestick(JSONArray array) {
		super(array);
	}
	
	//Geters
	@Override
	public final long getOpenTime() {
		return this.openTime;
	}

	@Override
	public final long getCloseTime() {
		return this.closeTime;
	}

	@Override
	public final double getOpen() {
		return this.open;
	}

	@Override
	public final double getClose() {
		return this.close;
	}

	@Override
	public final double getLow() {
		return this.low;
	}

	@Override
	public final double getHigh() {
		return this.high;
	}
	
	public final int getNumberOfTrades() {
		return this.numberOfTrades;
	}
	
	public final double getQuoteAssetVolume() {
		return this.quoteAssetVolume;
	}
	
	public final double getTakerBuyBaseAssetVolume() {
		return this.takerBuyBaseAssetVolume;
	}
	
	public final double getTakerBuyQuoteAssetVolume() {
		return this.takerBuyQuoteAssetVolume;
	}
	
	public final double getVolume() {
		return this.volume;
	}
}