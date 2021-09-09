package fr.rowlaxx.binanceapi.core.general;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class RateLimit extends JSavONObject {
	private static final long serialVersionUID = 6004306452814605389L;
	
	//Variables
	@JOValue private int intervalNum;
	@JOValue private int limit;
	@JOValue private RateLimitIntervals interval;
	@JOValue private RateLimitTypes rateLimitType;
	
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
