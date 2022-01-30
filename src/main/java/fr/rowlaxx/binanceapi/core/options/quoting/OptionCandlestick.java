package fr.rowlaxx.binanceapi.core.options.quoting;

import org.json.JSONArray;

import fr.rowlaxx.binanceapi.core.Candlestick;
import fr.rowlaxx.binanceapi.core.Intervals;
import fr.rowlaxx.jsavon.JsavonArray;
import fr.rowlaxx.jsavon.annotations.JAValue;

public class OptionCandlestick extends JsavonArray implements Candlestick {
	private static final long serialVersionUID = -3133368743290654529L;
	
	//Variables
	@JAValue(index = 0) private double close;
	@JAValue(index = 1) private long closeTime;
	@JAValue(index = 2) private int tradeCount;
	@JAValue(index = 3) private double high;
	@JAValue(index = 4) private double low;
	@JAValue(index = 5) private double open;
	@JAValue(index = 6) private long openTime;
	@JAValue(index = 7) private double takerAmount;
	@JAValue(index = 8) private double takerVolume;
	@JAValue(index = 9) private Intervals interval;	
	@JAValue(index = 10) private double volume;

	//Constructeurs
	public OptionCandlestick(JSONArray json) {
		super(json);
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

	public final double getVolume() {
		return this.volume;
	}
	
	public final Intervals getInterval() {
		return interval;
	}
	
	public final double getTakerAmount() {
		return takerAmount;
	}
	
	public final double getTakerVolume() {
		return takerVolume;
	}
	
	public final int getTradeCount() {
		return tradeCount;
	}
}
