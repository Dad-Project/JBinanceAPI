package fr.rowlaxx.temp.marketdataendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import java.util.List;

import org.json.JSONObject;

public class OrderBook extends JSavONObject {
	private static final long serialVersionUID = -1189766329825065372L;
	
	//Variables
	private List<Object> asks;
	private List<Object> bids;
	private int lastUpdateId;
	
	//Constructeurs
	public OrderBook(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<Object> getAsks() {
		return this.asks;
	}
	
	public final List<Object> getBids() {
		return this.bids;
	}
	
	public final int getLastUpdateId() {
		return this.lastUpdateId;
	}
}