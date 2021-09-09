package fr.rowlaxx.binanceapi.core.general.filters;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.Filter;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class ExchangeMaxNumAlgoOrdersFilter extends Filter {
	private static final long serialVersionUID = -5708475118928196546L;

	//Variables
	@JOValue private int maxNumAlgoOrders;

	//Constructeurs
	public ExchangeMaxNumAlgoOrdersFilter(JSONObject response) {
		super(response);
	}

	//Getters
	public int getMaxNumAlgoOrders() {
		return maxNumAlgoOrders;
	}
}