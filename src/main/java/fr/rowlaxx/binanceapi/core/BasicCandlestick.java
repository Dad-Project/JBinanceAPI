package fr.rowlaxx.binanceapi.core;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonArray;
import fr.rowlaxx.jsavon.annotations.JAValue;

public class BasicCandlestick extends JsavonArray implements Candlestick.Volume {
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
	@JAValue(index = 11) private double ignore;
	
	//Constructeurs
	public BasicCandlestick(JSONArray array) {
		super(array);
	}
	
	public BasicCandlestick(JSONObject json) {
		this.openTime = json.getLong("t");
		this.closeTime = json.getLong("T");
		this.open = json.getDouble("o");
		this.close = json.getDouble("c");
		this.high = json.getDouble("h");
		this.low = json.getDouble("l");
		this.volume = json.getDouble("v");
		this.numberOfTrades = json.getInt("n");
		this.quoteAssetVolume = json.getDouble("q");
		this.takerBuyBaseAssetVolume = json.getDouble("V");
		this.takerBuyQuoteAssetVolume = json.getDouble("Q");
		this.ignore = json.getDouble("B");
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
	
	public final double getIgnoreData() {
		return ignore;
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
	
	@Override
	public final int getNumberOfTrades() {
		return this.numberOfTrades;
	}
	
	public final double getQuoteAssetVolume() {
		return this.quoteAssetVolume;
	}
	
	@Override
	public final double getTakerBuyBaseAssetVolume() {
		return this.takerBuyBaseAssetVolume;
	}
	
	@Override
	public final double getTakerBuyQuoteAssetVolume() {
		return this.takerBuyQuoteAssetVolume;
	}
	
	@Override
	public final double getVolume() {
		return this.volume;
	}
}