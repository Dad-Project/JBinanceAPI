package fr.rowlaxx.binanceapi.core.api.blvt;

import org.json.JSONArray;

import fr.rowlaxx.binanceapi.core.market.Candlestick;
import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValueArray;

public class BlvtCandlestick extends BinanceResponseJSON implements Candlestick {
	private static final long serialVersionUID = 3010375980418082181L;
	
	//Variables
	@JsonValueArray(index = 0) private long openTime;
	@JsonValueArray(index = 6) private long closeTime;
	@JsonValueArray(index = 2) private double high;
	@JsonValueArray(index = 3) private double low;
	@JsonValueArray(index = 1) private double open;
	@JsonValueArray(index = 4) private double close;
	@JsonValueArray(index = 5) private double realLeverage;
	@JsonValueArray(index = 8) private long numberOfNavUpdate;
	
	//Constructeurs
	public BlvtCandlestick(JSONArray response) {
		super(response);
	}

	//Getters
	@Override
	public long getOpenTime() {
		return openTime;
	}

	@Override
	public long getCloseTime() {
		return closeTime;
	}

	@Override
	public double getOpen() {
		return open;
	}

	@Override
	public double getClose() {
		return close;
	}

	@Override
	public double getLow() {
		return low;
	}

	@Override
	public double getHigh() {
		return high;
	}
	
	public long getNumberOfNavUpdate() {
		return numberOfNavUpdate;
	}
	
	public double getRealLeverage() {
		return realLeverage;
	}
}
