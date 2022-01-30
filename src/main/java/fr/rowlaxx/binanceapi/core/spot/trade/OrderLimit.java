package fr.rowlaxx.binanceapi.core.spot.trade;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.RateLimit;

public class OrderLimit extends RateLimit {
	private static final long serialVersionUID = -4588960052188889320L;

	private int count;
	
	public OrderLimit(JSONObject response) {
		super(response);
	}
	
	public int getCount() {
		return count;
	}

}
