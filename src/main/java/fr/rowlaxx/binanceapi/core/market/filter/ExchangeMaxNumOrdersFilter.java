package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class ExchangeMaxNumOrdersFilter extends ExchangeFilter {
	private static final long serialVersionUID = 338992389513437314L;

	//Variables
	@JsonValue private int maxNumOrders;

	//Constructeurs
	public ExchangeMaxNumOrdersFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getMaxNumOrders() {
		return maxNumOrders;
	}
}