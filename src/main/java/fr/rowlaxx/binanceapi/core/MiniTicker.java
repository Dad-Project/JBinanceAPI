package fr.rowlaxx.binanceapi.core;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class MiniTicker extends JsavonObject {
	private static final long serialVersionUID = -1160108214836138288L;
	
	//Variables
	@JOValue(key = "s")
	private String symbol;
	@JOValue(key = "c")
	private double close;
	@JOValue(key = "o")
	private double open;
	@JOValue(key = "h")
	private double high;
	@JOValue(key = "l")
	private double low;
	@JOValue(key = "v")
	private double volume;
	@JOValue(key = "q")
	private double quoteAssetVolume;
	
	//Getters
	public double getClose() {
		return close;
	}
	
	public double getHigh() {
		return high;
	}
	
	public double getLow() {
		return low;
	}
	
	public double getOpen() {
		return open;
	}
	
	public double getQuoteAssetVolume() {
		return quoteAssetVolume;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public double getVolume() {
		return volume;
	}
}
