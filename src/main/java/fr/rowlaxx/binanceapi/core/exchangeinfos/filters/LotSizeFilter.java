package fr.rowlaxx.binanceapi.core.exchangeinfos.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.Filter;

public class LotSizeFilter extends Filter {
	private static final long serialVersionUID = -2565960358312949329L;

	//Variables
	private double minQty;
	private double maxQty;
	private double stepSize;

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