package fr.rowlaxx.binanceapi.core.market.blvt;

import org.json.JSONArray;

import fr.rowlaxx.binanceapi.core.market.Candlestick;
import fr.rowlaxx.jsavon.JSavONArray;
import fr.rowlaxx.jsavon.annotations.array.JAValue;

public class BlvtCandlestick extends JSavONArray implements Candlestick {
	private static final long serialVersionUID = -2836222048640903246L;

	//Variables
	@JAValue(index = 0) private long openTime;
	@JAValue(index = 1) private double open;
	@JAValue(index = 2) private double high;
	@JAValue(index = 3) private double low;
	@JAValue(index = 4) private double close;
	@JAValue(index = 5) private double realLeverage;
	@JAValue(index = 6) private long closeTime;
	@JAValue(index = 8) private int numberOfNAVUpdate;
	
	//Constructeurs
	public BlvtCandlestick(JSONArray array) {
		super(array);
	}

	//Getters
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
	
	public final int getNumberOfNAVUpdate() {
		return this.numberOfNAVUpdate;
	}
	
	public final double getRealLeverage() {
		return this.realLeverage;
	}
}
