package fr.rowlaxx.binanceapi.core.general.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.Filter;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class MaxNumOrdersFilter extends Filter {
	private static final long serialVersionUID = 850292844039211819L;

	//Variables
	@JOValue(key = {"maxNumOrders", "limit"}) private int maxNumOrders;

	//Constructeurs
	public MaxNumOrdersFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getMaxNumOrders() {
		return maxNumOrders;
	}
}