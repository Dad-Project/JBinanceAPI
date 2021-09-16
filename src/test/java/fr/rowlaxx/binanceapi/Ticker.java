package fr.rowlaxx.binanceapi;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class Ticker extends JSavONObject {
	private static final long serialVersionUID = -4065395484778967252L;
	
	//Variables
	@JOValue(key = "s")
	private String symbol;
	@JOValue(key = "b")
	private double bidPrice;
	@JOValue(key = "B")
	private double bidQty;
	@JOValue(key = "a")
	private double askPrice;
	@JOValue(key = "A")
	private double askQty;
	@JOValue(key = "u")
	private long updateId;
	@JOValue(key = "E")
	private long eventIime;
	@JOValue(key = "T")
	private long transactionTime;
	
	//Constructeurs
	public Ticker(JSONObject json) {
		super(json);
	}
	
	//Getters
	public double getAskPrice() {
		return askPrice;
	}
	
	public double getAskQty() {
		return askQty;
	}
	
	public double getBidPrice() {
		return bidPrice;
	}
	
	public double getBidQty() {
		return bidQty;
	}
	
	public long getEventIime() {
		return eventIime;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public long getTransactionTime() {
		return transactionTime;
	}
	
	public long getUpdateId() {
		return updateId;
	}
}
