package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class MinNotionalFilter extends SymbolFilter {
	private static final long serialVersionUID = -1311500546629219225L;
	
	//Variables
	@JsonValue private int minNotional;
	@JsonValue private boolean applyToMarket;
	@JsonValue private int avgPriceMins;

	//Constructeurs
	public MinNotionalFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getAvgPriceMins() {
		return avgPriceMins;
	}
	
	public int getMinNotional() {
		return minNotional;
	}
	
	public boolean getApplyToMarket() {
		return applyToMarket;
	}
}