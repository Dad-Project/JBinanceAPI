package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class PercentPriceFilter extends SymbolFilter {
	private static final long serialVersionUID = -8439783889456487614L;

	//Variables
	@JsonValue private double multiplierUp;
	@JsonValue private double multiplierDown;
	@JsonValue private int avgPriceMins;

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

	public int getAvgPriceMins() {
		return avgPriceMins;
	}
}