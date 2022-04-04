package fr.rowlaxx.binanceapi.core;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;
import fr.rowlaxx.jsavon.annotations.ManualValue;

import java.util.Map;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OrderBook extends JsavonObject {
	private static final long serialVersionUID = -1189766329825065372L;
	
	//Variables
	@ManualValue
	private Map<Double, Double> asks = new TreeMap<>( (Double o1, Double o2) -> Double.compare(o1, o2) );
	@ManualValue
	private Map<Double, Double> bids = new TreeMap<> ((Double o1, Double o2) -> Double.compare(o1, o2) );
	
	@JOValue(mandatory = false, key = {"lastUpdateId", "u"})
	private Long lastUpdateId;
	@JOValue(mandatory = false)
	private String pair;
	@JOValue(mandatory = false, key = {"symbol", "s"})
	private String symbol;
	@JOValue(mandatory = false, key = "U")
	private Long firstUpdateId;
	
	//Constructeurs
	public OrderBook(JSONObject json) {
		super(json);
		JSONArray array;
		
		try {
			for (Object obj : json.getJSONArray("bids")) {
				array = (JSONArray) obj;
				bids.put(array.getDouble(0), array.getDouble(1));
			}
			for (Object obj : json.getJSONArray("asks")) {
				array = (JSONArray) obj;
				asks.put(array.getDouble(0), array.getDouble(1));
			}
		}catch(JSONException e) {
			for (Object obj : json.getJSONArray("b")) {
				array = (JSONArray) obj;
				bids.put(array.getDouble(0), array.getDouble(1));
			}
			for (Object obj : json.getJSONArray("a")) {
				array = (JSONArray) obj;
				asks.put(array.getDouble(0), array.getDouble(1));
			}
		}
	}
	
	//Getters
	public Map<Double, Double> getAsks() {
		return asks;
	}
	
	public Map<Double, Double> getBids() {
		return bids;
	}
	
	public final Long getLastUpdateId() {
		return this.lastUpdateId;
	}
	
	public final Long getFirstUpdateId() {
		return firstUpdateId;
	}
	
	public final String getPair() {
		return pair;
	}
	
	public final String getSymbol() {
		return symbol;
	}
}