package fr.rowlaxx.binanceapi.core.market;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class RateLimit extends BinanceResponseJSON {
	private static final long serialVersionUID = 6004306452814605389L;
	
	//Variables
	@JsonValue private int intervalNum;
	@JsonValue private int limit;
	@JsonValue private RateLimitIntervals interval;
	@JsonValue private RateLimitTypes rateLimitType;
	
	//Constructeurs
	public RateLimit(JSONObject response) {
		super(response);
	}
	
	//Getters
	public RateLimitIntervals getInterval() {
		return interval;
	}
	
	public int getIntervalNum() {
		return intervalNum;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public RateLimitTypes getRateLimitType() {
		return rateLimitType;
	}
}
