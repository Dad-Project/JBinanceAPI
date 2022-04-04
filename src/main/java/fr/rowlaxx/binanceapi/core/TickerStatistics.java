package fr.rowlaxx.binanceapi.core;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public abstract class TickerStatistics extends JsavonObject {
	private static final long serialVersionUID = -2572423328910643620L;

	//Variables
	@JOValue(key = {"symbol", "s"})
	private String symbol;
	@JOValue(key = {"priceChange","p"})
	private double priceChange;
	@JOValue(key = {"priceChangePercent","P"})
	private double priceChangePercent;
	@JOValue(key = {"weightedAvgPrice","w"})
	private double weightedAvgPrice;
	@JOValue(key = {"lastPrice","c"})
	private double lastPrice;
	@JOValue(key = {"lastQty","Q"})
	private double lastQty;
	@JOValue(key = {"lowPrice","l"})
	private double lowPrice;
	@JOValue(key = {"openPrice","o"})
	private double openPrice;
	@JOValue(key = {"highPrice","h"})
	private double highPrice;
	@JOValue(key = {"closeTime","O"})
	private long closeTime;
	@JOValue(key = {"openTime","C"})
	private long openTime;
	@JOValue(key = {"volume","v"})
	private double volume;
	@JOValue(key = {"count", "n"})
	private int tradeCount;
	@JOValue(key = {"firstId","F"})
	private long firstTradeId;
	@JOValue(key = {"lastId","L"})
	private long lastTradeId;
	
	//Constructeurs
	public TickerStatistics(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final double getVolume() {
		return this.volume;
	}
	
	public final double getWeightedAvgPrice() {
		return this.weightedAvgPrice;
	}
	
	public final double getPriceChange() {
		return this.priceChange;
	}
	
	public final double getPriceChangePercent() {
		return this.priceChangePercent;
	}
	
	public final long getCloseTime() {
		return this.closeTime;
	}
	
	public final int getTradeCount() {
		return this.tradeCount;
	}
	
	public final double getHighPrice() {
		return this.highPrice;
	}

	public final long getFirstTradeId() {
		return firstTradeId;
	}
	
	public final long getLastTradeId() {
		return lastTradeId;
	}
	
	public final double getLastPrice() {
		return this.lastPrice;
	}
	
	public final double getLastQty() {
		return this.lastQty;
	}
	
	public final double getLowPrice() {
		return this.lowPrice;
	}
	
	public final double getOpenPrice() {
		return this.openPrice;
	}
	
	public final long getOpenTime() {
		return this.openTime;
	}
}