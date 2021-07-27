package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.market.filter.Filters.Type;

public class ExchangeFilter extends Filter {
	private static final long serialVersionUID = 8263191783862810795L;

	//Constructeurs
	ExchangeFilter(JSONObject response) {
		super(response);
		if (getFilterType().getType() != Type.SYMBOL)
			throw new IllegalArgumentException("The filterType must be an exchange filter");
	}

}
