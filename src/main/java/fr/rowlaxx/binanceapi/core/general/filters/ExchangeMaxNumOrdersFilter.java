package fr.rowlaxx.binanceapi.core.general.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.Filter;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class ExchangeMaxNumOrdersFilter extends Filter {
	private static final long serialVersionUID = 338992389513437314L;

	//Variables
	@JOValue private int maxNumOrders;

	//Constructeurs
	public ExchangeMaxNumOrdersFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getMaxNumOrders() {
		return maxNumOrders;
	}
}