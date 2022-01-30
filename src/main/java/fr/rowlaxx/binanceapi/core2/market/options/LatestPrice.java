package fr.rowlaxx.binanceapi.core2.market.options;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class LatestPrice extends JsavonObject {
	private static final long serialVersionUID = 8358192541868121515L;
	
	//Variables
	private String amount;
	private double askPrice;
	private double bidPrice;
	private long closeTime;
	private double high;
	private int lastPrice;
	private int lastQty;
	private int low;
	private double open;
	private long openTime;
	private double priceChange;
	private double priceChangePercent;
	private int strikePrice;
	private String symbol;
	private int tradeCount;
	private int volume;
	
	//Constructeurs
	public LatestPrice(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAmount() {
		return this.amount;
	}
	
	public final double getAskPrice() {
		return this.askPrice;
	}
	
	public final double getBidPrice() {
		return this.bidPrice;
	}
	
	public final long getCloseTime() {
		return this.closeTime;
	}
	
	public final double getHigh() {
		return this.high;
	}
	
	public final int getLastPrice() {
		return this.lastPrice;
	}
	
	public final int getLastQty() {
		return this.lastQty;
	}
	
	public final int getLow() {
		return this.low;
	}
	
	public final double getOpen() {
		return this.open;
	}
	
	public final long getOpenTime() {
		return this.openTime;
	}
	
	public final double getPriceChange() {
		return this.priceChange;
	}
	
	public final double getPriceChangePercent() {
		return this.priceChangePercent;
	}
	
	public final int getStrikePrice() {
		return this.strikePrice;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final int getTradeCount() {
		return this.tradeCount;
	}
	
	public final int getVolume() {
		return this.volume;
	}
}