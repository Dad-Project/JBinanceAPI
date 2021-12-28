package fr.rowlaxx.binanceapi.core.general.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.Filter;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class MaxNumAlgoOrdersFilter extends Filter {
	private static final long serialVersionUID = -5831433014614011598L;

	//Variables
	@JOValue(key = {"maxNumAlgoOrders", "limit"}) private int maxNumAlgoOrders;

	//Constructeurs
	public MaxNumAlgoOrdersFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getMaxNumAlgoOrders() {
		return maxNumAlgoOrders;
	}
}