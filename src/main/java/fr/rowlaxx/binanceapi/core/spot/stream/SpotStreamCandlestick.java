package fr.rowlaxx.binanceapi.core.spot.stream;

import fr.rowlaxx.binanceapi.core.Candlestick;
import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class SpotStreamCandlestick extends JsavonObject implements Candlestick.Volume {
	private static final long serialVersionUID = 2846782807729853968L;
	
	//Variables
	@JOValue(key = "t")
	private long startTime;
	@JOValue(key = "T")
	private long closeTime;
	@JOValue(key = "f")
	private long firstTradeId;
	@JOValue(key = "L")
	private long lastTradeId;
	@JOValue(key = "o")
	private double open;
	@JOValue(key = "c")
	private double close;
	@JOValue(key = "h")
	private double high;
	@JOValue(key = "l")
	private double low;
	@JOValue(key = "v")
	private double volume;
	@JOValue(key = "n")
	private int numberOfTrades;
	@JOValue(key = "x")
	private boolean isClosed;
	@JOValue(key = "q")
	private double quoteAssetVolume;
	@JOValue(key = "V")
	private double takerBuyBaseAssetVolume;
	@JOValue(key = "Q")
	private double takerBuyQuoteAssetVolume;
	@JOValue(key = "B")
	private double ignore;
	
	//Methodes
	@Override
	public long getOpenTime() {
		return startTime;
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
	@Override
	public double getVolume() {
		return volume;
	}
	@Override
	public int getNumberOfTrades() {
		return numberOfTrades;
	}
	@Override
	public double getTakerBuyBaseAssetVolume() {
		return takerBuyBaseAssetVolume;
	}
	@Override
	public double getTakerBuyQuoteAssetVolume() {
		return takerBuyQuoteAssetVolume;
	}
	
	public long getFirstTradeId() {
		return firstTradeId;
	}
	
	public double getIgnore() {
		return ignore;
	}
	
	public long getLastTradeId() {
		return lastTradeId;
	}
	
	public double getQuoteAssetVolume() {
		return quoteAssetVolume;
	}
}
