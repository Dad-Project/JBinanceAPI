package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class MarketLotSizeFilter extends SymbolFilter {
	private static final long serialVersionUID = 8424960315978402123L;

	//Variables
	@JsonValue private double minQty;
	@JsonValue private double maxQty;
	@JsonValue private double stepSize;

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