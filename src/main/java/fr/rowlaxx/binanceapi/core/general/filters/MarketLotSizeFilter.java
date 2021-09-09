package fr.rowlaxx.binanceapi.core.general.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.Filter;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class MarketLotSizeFilter extends Filter {
	private static final long serialVersionUID = 8424960315978402123L;

	//Variables
	@JOValue private double minQty;
	@JOValue private double maxQty;
	@JOValue private double stepSize;

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