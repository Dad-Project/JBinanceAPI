package fr.rowlaxx.binanceapi.core.exchangeinfos.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.Filter;

public class ExchangeMaxNumAlgoOrdersFilter extends Filter {
	private static final long serialVersionUID = -5708475118928196546L;

	//Variables
	private int maxNumAlgoOrders;

	//Constructeurs
	public ExchangeMaxNumAlgoOrdersFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getMaxNumAlgoOrders() {
		return maxNumAlgoOrders;
	}
}