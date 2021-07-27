package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class MaxNumOrdersFilter extends SymbolFilter {
	private static final long serialVersionUID = 850292844039211819L;

	//Variables
	@JsonValue private int maxNumOrders;

	//Constructeurs
	public MaxNumOrdersFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getMaxNumOrders() {
		return maxNumOrders;
	}
}