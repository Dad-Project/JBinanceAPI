package fr.rowlaxx.binanceapi.core.exchangeinfos.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.Filter;

public class PercentPriceBySideFilter extends Filter {
	private static final long serialVersionUID = -5941252554825429487L;

	private double bidMultiplierUp;
	private double bidMultiplierDown;
	private double askMultiplierUp;
	private double askMultiplierDown;
	private double avgPriceMins;
	
	public PercentPriceBySideFilter(JSONObject response) {
		super(response);
	}
	
	public final double getAskMultiplierDown() {
		return askMultiplierDown;
	}
	
	public final double getAskMultiplierUp() {
		return askMultiplierUp;
	}
	
	public final double getAvgPriceMins() {
		return avgPriceMins;
	}
	
	public final double getBidMultiplierDown() {
		return bidMultiplierDown;
	}
	
	public final double getBidMultiplierUp() {
		return bidMultiplierUp;
	}
}
