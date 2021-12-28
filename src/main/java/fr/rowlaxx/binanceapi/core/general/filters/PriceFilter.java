package fr.rowlaxx.binanceapi.core.general.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.Filter;

public class PriceFilter extends Filter {
	private static final long serialVersionUID = -5438080066960880647L;

	//Variables
	private double minPrice;
	private double maxPrice;
	private double tickSize;

	//Constructeurs
	public PriceFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public double getMinPrice() {
		return minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public double getTickSize() {
		return tickSize;
	}
}