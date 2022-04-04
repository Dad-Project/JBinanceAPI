package fr.rowlaxx.binanceapi.core.spot.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.TickerStatistics;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class SpotTickerStatistics extends TickerStatistics {
	private static final long serialVersionUID = 2670087711525505652L;
	
	//Variables
	@JOValue(key = {"askPrice","a"})
	private double askPrice;
	@JOValue(key = {"askQty","A"})
	private double askQty;
	@JOValue(key = {"bidPrice","b"})
	private double bidPrice;
	@JOValue(key = {"bidQty","B"})
	private double bidQty;
	@JOValue(mandatory = false)
	private Double prevClosePrice;
	@JOValue(key = {"quoteVolume","q"})
	private double quoteVolume;
	
	@JOValue(mandatory = false, key = "x")
	private Double firstTrade;
	
	//Constructeurs
	public SpotTickerStatistics(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAskPrice() {
		return this.askPrice;
	}
	
	public final double getBidPrice() {
		return this.bidPrice;
	}
	
	public final Double getPrevClosePrice() {
		return this.prevClosePrice;
	}
	
	public final double getQuoteVolume() {
		return this.quoteVolume;
	}
	
	public final double getAskQty() {
		return this.askQty;
	}
	
	public Double getFirstTrade() {
		return firstTrade;
	}
	
	public final double getBidQty() {
		return this.bidQty;
	}
}