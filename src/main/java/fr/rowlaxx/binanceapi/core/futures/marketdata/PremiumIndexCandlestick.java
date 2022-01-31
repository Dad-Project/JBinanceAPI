package fr.rowlaxx.binanceapi.core.futures.marketdata;

import org.json.JSONArray;

import fr.rowlaxx.binanceapi.core.Candlestick;
import fr.rowlaxx.jsavon.JsavonArray;
import fr.rowlaxx.jsavon.annotations.JAValue;

public class PremiumIndexCandlestick extends JsavonArray implements Candlestick {
	private static final long serialVersionUID = -2836222048640903246L;

	//Variables
	@JAValue(index = 0) private long openTime;
	@JAValue(index = 1) private double open;
	@JAValue(index = 2) private double high;
	@JAValue(index = 3) private double low;
	@JAValue(index = 4) private double close;
	@JAValue(index = 5) private double ignore1;
	@JAValue(index = 6) private long closeTime;
	@JAValue(index = 7) private double ignore2;
	@JAValue(index = 8) private int numberOfBisicData;
	@JAValue(index = 9) private double ignore3;
	@JAValue(index = 10) private double ignore4;
	@JAValue(index = 11) private double ignore5;

	//Constructeurs
	public PremiumIndexCandlestick(JSONArray array) {
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
	
	public final double getIgnoreData5() {
		return ignore5;
	}
	
	public final int getNumberOfBisicData() {
		return numberOfBisicData;
	}
}
