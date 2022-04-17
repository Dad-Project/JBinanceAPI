package fr.rowlaxx.binanceapi.core.blvt;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.Candlestick;
import fr.rowlaxx.jsavon.JsavonArray;
import fr.rowlaxx.jsavon.annotations.JAValue;

public class BlvtCandlestick extends JsavonArray implements Candlestick {
	private static final long serialVersionUID = -2836222048640903246L;

	//Variables
	@JAValue(index = 0) private long openTime;
	@JAValue(index = 1) private double open;
	@JAValue(index = 2) private double high;
	@JAValue(index = 3) private double low;
	@JAValue(index = 4) private double close;
	@JAValue(index = 5) private double realLeverage;
	@JAValue(index = 6) private long closeTime;
	@JAValue(index = 7) private double ignore1;
	@JAValue(index = 8) private int numberOfNAVUpdate;
	@JAValue(index = 9) private double ignore2;
	@JAValue(index = 10) private double ignore3;
	@JAValue(index = 11) private double ignore4;

	//Constructeurs
	public BlvtCandlestick(JSONArray array) {
		super(array);
	}

	public BlvtCandlestick(JSONObject json) {
		this.open = json.getDouble("o");
		this.close = json.getDouble("c");
		this.high = json.getDouble("h");
		this.low = json.getDouble("l");
		this.realLeverage = json.getDouble("v");
		this.numberOfNAVUpdate = json.getInt("n");
		this.openTime = json.getLong("t");
		this.closeTime = json.getLong("T");
		this.ignore2 = json.getDouble("V");
		this.ignore1 = json.getDouble("q");
		this.ignore3 = json.getDouble("Q");
		this.ignore4 = json.getDouble("B");
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
	
	public final double getIgnoreData1() {
		return ignore1;
	}
	
	public final double getIgnoreData2() {
		return ignore2;
	}
	
	public final double getIgnoreData3() {
		return ignore3;
	}
	
	public final double getIgnoreData4() {
		return ignore4;
	}
	
	public final int getNumberOfNAVUpdate() {
		return this.numberOfNAVUpdate;
	}
	
	public final double getRealLeverage() {
		return this.realLeverage;
	}
}
