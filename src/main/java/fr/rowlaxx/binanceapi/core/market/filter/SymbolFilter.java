package fr.rowlaxx.binanceapi.core.market.filter;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.market.filter.Filters.Type;

public abstract class SymbolFilter extends Filter {
	private static final long serialVersionUID = -2698002340161436528L;

	//Constructeurs
	SymbolFilter(JSONObject response) {
		super(response);
		if (getFilterType().getType() != Type.SYMBOL)
			throw new IllegalArgumentException("The filterType must be a symbol filter");
	}

}
