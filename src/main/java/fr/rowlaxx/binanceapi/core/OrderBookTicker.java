package fr.rowlaxx.binanceapi.core;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class OrderBookTicker extends JsavonObject {
	private static final long serialVersionUID = 6781128770211592070L;
	
	//Variables
	private double askPrice;
	private double askQty;
	private double bidPrice;
	private double bidQty;
	private String symbol;
	@JOValue(mandatory = false) private Long time;
	
	//Constructeurs
	public OrderBookTicker(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Long getTime() {
		return time;
	}
	
	public final double getAskPrice() {
		return this.askPrice;
	}
	
	public final double getAskQty() {
		return this.askQty;
	}
	
	public final double getBidPrice() {
		return this.bidPrice;
	}
	
	public final double getBidQty() {
		return this.bidQty;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}