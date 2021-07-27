package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class PriceFilter extends SymbolFilter {
	private static final long serialVersionUID = -5438080066960880647L;

	//Variables
	@JsonValue private double minPrice;
	@JsonValue private double maxPrice;
	@JsonValue private double tickSize;

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