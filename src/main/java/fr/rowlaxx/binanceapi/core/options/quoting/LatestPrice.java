package fr.rowlaxx.binanceapi.core.options.quoting;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class LatestPrice extends JsavonObject {
	private static final long serialVersionUID = 8358192541868121515L;
	
	//Variables
	private String symbol;
	private double priceChange;
	private double priceChangePercent;
	private double lastPrice;
	private double lastQty;
	private double open;
	private double high;
	private double low;
	private double bidPrice;
	private double askPrice;
	private double volume;
	private String amount;
	private long openTime;
	private long closeTime;
	private double strikePrice;
	private int tradeCount;
	private double exercicePrice;
	
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
	
	public final double getLastPrice() {
		return this.lastPrice;
	}
	
	public final double getLastQty() {
		return this.lastQty;
	}
	
	public final double getLow() {
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
	
	public final double getStrikePrice() {
		return this.strikePrice;
	}
	
	public final double getExercicePrice() {
		return exercicePrice;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final int getTradeCount() {
		return this.tradeCount;
	}
	
	public final double getVolume() {
		return this.volume;
	}
}