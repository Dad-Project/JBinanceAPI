package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class ExchangeMaxNumAlgoOrdersFilter extends ExchangeFilter {
	private static final long serialVersionUID = -5708475118928196546L;

	//Variables
	@JsonValue private int maxNumAlgoOrders;

	//Constructeurs
	public ExchangeMaxNumAlgoOrdersFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getMaxNumAlgoOrders() {
		return maxNumAlgoOrders;
	}
}