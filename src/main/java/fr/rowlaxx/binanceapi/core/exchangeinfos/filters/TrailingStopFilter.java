package fr.rowlaxx.binanceapi.core.exchangeinfos.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.Filter;

public class TrailingStopFilter extends Filter {
	private static final long serialVersionUID = 251607060890132932L;

	//Variables
	private double minTrailingAboveDelta;
	private double maxTrailingAboveDelta;
	private double minTrailingBelowDelta;
	private double maxTrailingBelowDelta;
	
	//Constructeurs
	public TrailingStopFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public double getMaxTrailingAboveDelta() {
		return maxTrailingAboveDelta;
	}
	
	public double getMaxTrailingBelowDelta() {
		return maxTrailingBelowDelta;
	}
	
	public double getMinTrailingAboveDelta() {
		return minTrailingAboveDelta;
	}
	
	public double getMinTrailingBelowDelta() {
		return minTrailingBelowDelta;
	}
}
