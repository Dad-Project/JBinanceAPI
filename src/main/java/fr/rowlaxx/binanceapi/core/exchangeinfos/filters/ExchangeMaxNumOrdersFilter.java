package fr.rowlaxx.binanceapi.core.exchangeinfos.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.Filter;

public class ExchangeMaxNumOrdersFilter extends Filter {
	private static final long serialVersionUID = 338992389513437314L;

	//Variables
	private int maxNumOrders;

	//Constructeurs
	public ExchangeMaxNumOrdersFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getMaxNumOrders() {
		return maxNumOrders;
	}
}