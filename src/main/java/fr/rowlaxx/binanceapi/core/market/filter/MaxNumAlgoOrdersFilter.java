package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class MaxNumAlgoOrdersFilter extends SymbolFilter {
	private static final long serialVersionUID = -5831433014614011598L;

	//Variables
	@JsonValue private int maxNumAlgoOrders;

	//Constructeurs
	public MaxNumAlgoOrdersFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getMaxNumAlgoOrders() {
		return maxNumAlgoOrders;
	}
}