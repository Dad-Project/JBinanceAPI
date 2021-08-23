package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSONException;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class MinNotionalFilter extends SymbolFilter {
	private static final long serialVersionUID = -1311500546629219225L;
	
	//Variables
	private double minNotional;
	@JsonValue(mandatory = false) private boolean applyToMarket;
	@JsonValue(mandatory = false) private int avgPriceMins;

	//Constructeurs
	public MinNotionalFilter(JSONObject response) {
		super(response);
		if (response.has("minNotional"))
			minNotional = Double.parseDouble(response.getString("minNotional"));
		else if (response.has("notional"))
			minNotional = response.getInt("notional");
		else
			throw new BinanceResponseJSONException("The field minNotional is mandatory.");
	}

	//Getters
	public int getAvgPriceMins() {
		return avgPriceMins;
	}
	
	public double getMinNotional() {
		return minNotional;
	}
	
	public boolean getApplyToMarket() {
		return applyToMarket;
	}
}