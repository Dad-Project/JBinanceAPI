package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSONException;

public class MaxNumOrdersFilter extends SymbolFilter {
	private static final long serialVersionUID = 850292844039211819L;

	//Variables
	private int maxNumOrders;

	//Constructeurs
	public MaxNumOrdersFilter(JSONObject response) {
		super(response);
		if (response.has("limit"))
			maxNumOrders = response.getInt("limit");
		else if (response.has("maxNumOrders"))
			maxNumOrders = response.getInt("maxNumOrders");
		else
			throw new BinanceResponseJSONException("The field maxNumOrders is mandatory.");
	}

	//Getters
	public int getMaxNumOrders() {
		return maxNumOrders;
	}
}