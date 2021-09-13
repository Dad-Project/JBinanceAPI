package fr.rowlaxx.binanceapi.core.general.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.Filter;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class MinNotionalFilter extends Filter {
	private static final long serialVersionUID = -1311500546629219225L;
	
	//Variables
	@JOValue(key = {"minNotional", "notional"}) private double minNotional;
	@JOValue(mandatory = false) private Boolean applyToMarket;
	@JOValue(mandatory = false) private Integer avgPriceMins;

	//Constructeurs
	public MinNotionalFilter(JSONObject response) {
		super(response);
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