package fr.rowlaxx.binanceapi.core.exchangeinfos.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.Filter;

public class MarketLotSizeFilter extends Filter {
	private static final long serialVersionUID = 8424960315978402123L;

	//Variables
	private double minQty;
	private double maxQty;
	private double stepSize;

	//Constructeurs
	public MarketLotSizeFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public double getMinQty() {
		return minQty;
	}

	public double getMaxQty() {
		return maxQty;
	}

	public double getStepSize() {
		return stepSize;
	}
}