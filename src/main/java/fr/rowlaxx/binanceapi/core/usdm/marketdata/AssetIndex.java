package fr.rowlaxx.binanceapi.core.usdm.marketdata;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class AssetIndex extends JsavonObject {
	private static final long serialVersionUID = 2357083300642882041L;
	
	//Variables
	private double askBuffer;
	private double askRate;
	private double autoExchangeAskBuffer;
	private double autoExchangeAskRate;
	private double autoExchangeBidBuffer;
	private double autoExchangeBidRate;
	private double bidBuffer;
	private double bidRate;
	private double index;
	private String symbol;
	private long time;
	
	//Constructeurs
	public AssetIndex(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAskBuffer() {
		return this.askBuffer;
	}
	
	public final double getAskRate() {
		return this.askRate;
	}
	
	public final double getAutoExchangeAskBuffer() {
		return this.autoExchangeAskBuffer;
	}
	
	public final double getAutoExchangeAskRate() {
		return this.autoExchangeAskRate;
	}
	
	public final double getAutoExchangeBidBuffer() {
		return this.autoExchangeBidBuffer;
	}
	
	public final double getAutoExchangeBidRate() {
		return this.autoExchangeBidRate;
	}
	
	public final double getBidBuffer() {
		return this.bidBuffer;
	}
	
	public final double getBidRate() {
		return this.bidRate;
	}
	
	public final double getIndex() {
		return this.index;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final long getTime() {
		return this.time;
	}
}