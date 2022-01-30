package fr.rowlaxx.binanceapi.core.exchangeinfos.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.Filter;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class PercentPriceFilter extends Filter {
	private static final long serialVersionUID = -8439783889456487614L;

	//Variables
	private double multiplierUp;
	private double multiplierDown;
	
	@JOValue(mandatory = false) 
	private Integer avgPriceMins;
	@JOValue(mandatory = false) 
	private Integer multiplierDecimal;
	
	//Constructeurs
	public PercentPriceFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public double getMultiplierDown() {
		return multiplierDown;
	}

	public double getMultiplierUp() {
		return multiplierUp;
	}
	
	public int getMultiplierDecimal() {
		return multiplierDecimal;
	}

	public int getAvgPriceMins() {
		return avgPriceMins;
	}
}