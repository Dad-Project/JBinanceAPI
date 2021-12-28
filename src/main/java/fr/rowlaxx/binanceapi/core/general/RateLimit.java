package fr.rowlaxx.binanceapi.core.general;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class RateLimit extends JsavonObject {
	private static final long serialVersionUID = 6004306452814605389L;
	
	//Variables
	private int intervalNum;
	private int limit;
	private RateLimitIntervals interval;
	private RateLimitTypes rateLimitType;
	
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
