package fr.rowlaxx.binanceapi.core.market;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;

public abstract class TickerPriceChangeStatistics24hr extends JSavONObject {
	private static final long serialVersionUID = -2572423328910643620L;

	//Variables
	private String symbol;
	private double priceChange;
	private double priceChangePercent;
	private double weightedAvgPrice;
	private double lastPrice;
	private double lastQty;
	private double lowPrice;
	private double openPrice;
	private double highPrice;
	private long closeTime;
	private long openTime;
	private double volume;
	private int count;
	private int firstId;
	private int lastId;

	//Constructeurs
	public TickerPriceChangeStatistics24hr(JSONObject json) {
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
	
	public final int getCount() {
		return this.count;
	}
	
	public final int getFirstId() {
		return this.firstId;
	}
	
	public final double getHighPrice() {
		return this.highPrice;
	}
	
	public final int getLastId() {
		return this.lastId;
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