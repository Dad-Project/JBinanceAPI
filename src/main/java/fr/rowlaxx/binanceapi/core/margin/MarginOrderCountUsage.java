package fr.rowlaxx.binanceapi.core.margin;

import fr.rowlaxx.binanceapi.core.exchangeinfos.RateLimitTypes;
import fr.rowlaxx.jsavon.JsavonObject;

public class MarginOrderCountUsage extends JsavonObject {
	private static final long serialVersionUID = -3666481347218858927L;

	//Variables
	private RateLimitTypes rateLimitTypes;
	private String interval;
	private int intervalNum;
	private int limit;
	private int count;
	
	//Getters
	public int getCount() {
		return count;
	}
	
	public String getInterval() {
		return interval;
	}
	
	public int getIntervalNum() {
		return intervalNum;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public RateLimitTypes getRateLimitTypes() {
		return rateLimitTypes;
	}
}
