package fr.rowlaxx.binanceapi.core.general;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.Filters.Type;
import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.ManualValue;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public abstract class Symbol extends JSavONObject {
	private static final long serialVersionUID = -6654992662838138776L;

	//Variables
	@JOValue private String symbol;
	@JOValue private String quoteAsset;

	@ManualValue
	private Map<Filters, Filter> filters;
	
	//Constructeurs
	public Symbol(JSONObject response) {
		super(response);
		final HashMap<Filters, Filter> filters = new HashMap<>();
		final JSONArray array = response.getJSONArray("filters");
		
		Filter filter;
		JSONObject json;
		for (int i = 0 ; i < array.length() ; i++) {
			json = array.getJSONObject(i);
			filter = Filter.fromJson(json);
			filters.put(filter.getFilterType(), filter);
		}
		this.filters = Collections.unmodifiableMap(filters);
	}
	
	//Getters
	public final Map<Filters, Filter> getFilters() {
		return filters;
	}
	
	@SuppressWarnings("unchecked")
	public final <F extends Filter> F getFilter(Filters filter) {
		if (filter == null)
			return null;
		if (filter.getType() == Type.SYMBOL)
			return (F) filters.get(filter);
		throw new IllegalArgumentException("filter may be a SYMBOL filter.");
	}
	
	public final String getQuoteAsset() {
		return quoteAsset;
	}
	
	public final String getSymbol() {
		return symbol;
	}
}