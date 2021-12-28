package fr.rowlaxx.binanceapi.core.market;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;
import fr.rowlaxx.jsavon.annotations.ManualValue;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class FinalOrderBook extends JsavonObject implements OrderBook {
	private static final long serialVersionUID = -1189766329825065372L;
	
	//Variables
	@ManualValue
	private Map<Double, Double> asks;
	@ManualValue
	private Map<Double, Double> bids;
	@JOValue(mandatory = false)
	private Long lastUpdateId;
	
	//Constructeurs
	public FinalOrderBook(JSONObject json) {
		super(json);
		JSONArray array;
		
		final Comparator<Double> comparator = new Comparator<Double>() {

			@Override
			public int compare(Double o1, Double o2) {
				return Double.compare(o1, o2);
			}
		};
		
		final TreeMap<Double, Double> bids = new TreeMap<>(comparator);
		final TreeMap<Double, Double> asks = new TreeMap<>(comparator);
		
		for (Object obj : json.getJSONArray("bids")) {
			array = (JSONArray) obj;
			bids.put(array.getDouble(0), array.getDouble(1));
		}
		for (Object obj : json.getJSONArray("asks")) {
			array = (JSONArray) obj;
			asks.put(array.getDouble(0), array.getDouble(1));
		}
		
		this.asks = Collections.unmodifiableMap(asks);
		this.bids = Collections.unmodifiableMap(bids);
	}
	
	//Getters
	@Override
	public Map<Double, Double> getAsks() {
		return asks;
	}
	
	@Override
	public Map<Double, Double> getBids() {
		return bids;
	}
	
	public final Long getLastUpdateId() {
		return this.lastUpdateId;
	}
}