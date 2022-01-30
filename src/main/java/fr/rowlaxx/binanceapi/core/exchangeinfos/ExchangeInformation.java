package fr.rowlaxx.binanceapi.core.exchangeinfos;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.Filters.Type;
import fr.rowlaxx.jsavon.annotations.ManualValue;
import fr.rowlaxx.jsavon.annotations.MapKey;

public abstract class ExchangeInformation<T extends SimpleSymbol> extends SimpleExchangeInformation<T> {
	private static final long serialVersionUID = 8865485419600969411L;

	//Variables
	private List<RateLimit> rateLimits;
	@MapKey(fieldName = "symbol")
	private Map<String, T> symbols;
	
	@ManualValue
	private Map<Filters, Filter> exchangeFilters;
	
	//Constructeurs
	public ExchangeInformation(JSONObject response) {
		super(response);
		
		final HashMap<Filters, Filter> filters = new HashMap<>();
		final JSONArray array = response.getJSONArray("exchangeFilters");
		Filter filter;
		for (int i = 0 ; i < array.length() ; i++) {
			filter = Filter.fromJson( array.getJSONObject(i) );
			filters.put(filter.getFilterType(), filter);
		}
		
		this.exchangeFilters = Collections.unmodifiableMap(filters);
	}
	
	//Getters
	public Map<Filters, Filter> getExchangeFilters() {
		return exchangeFilters;
	}
	
	@SuppressWarnings("unchecked")
	public <F extends Filter> F getExchangeFilter(Filters filter) {
		if (filter == null)
			return null;
		if (filter.getType() == Type.EXCHANGE)
			return (F) exchangeFilters.get(filter);
		throw new IllegalArgumentException("filter may be a EXCHANGE filter.");
	}
	
	public List<RateLimit> getRateLimits() {
		return rateLimits;
	}

	@Override
	public Map<String, T> getSymbols() {
		return symbols;
	}
}