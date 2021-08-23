package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSONException;

public class MaxNumAlgoOrdersFilter extends SymbolFilter {
	private static final long serialVersionUID = -5831433014614011598L;

	//Variables
	private int maxNumAlgoOrders;

	//Constructeurs
	public MaxNumAlgoOrdersFilter(JSONObject response) {
		super(response);
		if (response.has("limit"))
			maxNumAlgoOrders = response.getInt("limit");
		else if (response.has("maxNumAlgoOrders"))
			maxNumAlgoOrders = response.getInt("maxNumAlgoOrders");
		else
			throw new BinanceResponseJSONException("The field maxNumAlgoOrders is mandatory.");
	}

	//Getters
	public int getMaxNumAlgoOrders() {
		return maxNumAlgoOrders;
	}
}