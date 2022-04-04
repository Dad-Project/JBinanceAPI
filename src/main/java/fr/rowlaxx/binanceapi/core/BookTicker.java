package fr.rowlaxx.binanceapi.core;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class BookTicker extends JsavonObject {
	private static final long serialVersionUID = 6781128770211592070L;
	
	//Variables
	@JOValue(key = {"askPrice","a"})
	private double askPrice;
	@JOValue(key = {"askQty","A"})
	private double askQty;
	@JOValue(key = {"bidPrice","b"})
	private double bidPrice;
	@JOValue(key = {"bidQty","B"})
	private double bidQty;
	@JOValue(key = {"symbol","s"})
	private String symbol;
	
	@JOValue(mandatory = false) 
	private Long time;
	@JOValue(mandatory = false, key = "u")
	private Long updateId;
	
	//Constructeurs
	public BookTicker(JSONObject json) {
		super(json);
	}
	
	//Getters
	public Long getUpdateId() {
		return updateId;
	}
	
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