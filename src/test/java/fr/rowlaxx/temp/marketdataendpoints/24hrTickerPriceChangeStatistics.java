package fr.rowlaxx.temp.marketdataendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class 24hrTickerPriceChangeStatistics extends JSavONObject {
	private static final long serialVersionUID = 2670087711525505652L;
	
	//Variables
	private double askPrice;
	private double bidPrice;
	private long closeTime;
	private int count;
	private int firstId;
	private double highPrice;
	private int lastId;
	private double lastPrice;
	private double lastQty;
	private double lowPrice;
	private double openPrice;
	private long openTime;
	private double prevClosePrice;
	private double priceChange;
	private double priceChangePercent;
	private double quoteVolume;
	private String symbol;
	private double volume;
	private double weightedAvgPrice;
	
	//Constructeurs
	public 24hrTickerPriceChangeStatistics(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAskPrice() {
		return this.askPrice;
	}
	
	public final double getBidPrice() {
		return this.bidPrice;
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
	
	public final double getPrevClosePrice() {
		return this.prevClosePrice;
	}
	
	public final double getPriceChange() {
		return this.priceChange;
	}
	
	public final double getPriceChangePercent() {
		return this.priceChangePercent;
	}
	
	public final double getQuoteVolume() {
		return this.quoteVolume;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final double getVolume() {
		return this.volume;
	}
	
	public final double getWeightedAvgPrice() {
		return this.weightedAvgPrice;
	}
}