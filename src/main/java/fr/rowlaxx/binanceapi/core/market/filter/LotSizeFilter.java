package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class LotSizeFilter extends SymbolFilter {
	private static final long serialVersionUID = -2565960358312949329L;

	//Variables
	@JsonValue private double minQty;
	@JsonValue private double maxQty;
	@JsonValue private double stepSize;

	//Constructeurs
	public LotSizeFilter(JSONObject response) {
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