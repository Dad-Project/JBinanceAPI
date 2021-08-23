package fr.rowlaxx.binanceapi.core.market;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.market.filter.Filter;
import fr.rowlaxx.binanceapi.core.market.filter.Filters;
import fr.rowlaxx.binanceapi.core.market.filter.Filters.Type;
import fr.rowlaxx.binanceapi.core.market.filter.SymbolFilter;
import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public abstract class Symbol extends BinanceResponseJSON {
	private static final long serialVersionUID = -6654992662838138776L;

	//Variables
	@JsonValue private String symbol;
	@JsonValue private String baseAsset;
	@JsonValue private String quoteAsset;
	@JsonValue private int baseAssetPrecision;
	@JsonValue private int quotePrecision;
	
	private Map<Filters, SymbolFilter> filters;
	
	//Constructeurs
	public Symbol(JSONObject response) {
		super(response);
		final HashMap<Filters, SymbolFilter> filters = new HashMap<>();
		final JSONArray array = response.getJSONArray("filters");
		
		Filter filter;
		JSONObject json;
		for (int i = 0 ; i < array.length() ; i++) {
			json = array.getJSONObject(i);
			filter = Filter.fromJson(json);
			filters.put(filter.getFilterType(), (SymbolFilter) filter);
		}
		this.filters = Collections.unmodifiableMap(filters);
	}
	
	//Getters
	public String getBaseAsset() {
		return baseAsset;
	}
	
	public int getBaseAssetPrecision() {
		return baseAssetPrecision;
	}
	
	public Map<Filters, SymbolFilter> getFilters() {
		return filters;
	}
	
	public SymbolFilter getFilter(Filters filter) {
		if (filter == null)
			return null;
		if (filter.getType() == Type.SYMBOL)
			return filters.get(filter);
		throw new IllegalArgumentException("filter may be a SYMBOL filter.");
	}
	
	public String getQuoteAsset() {
		return quoteAsset;
	}
	
	public int getQuotePrecision() {
		return quotePrecision;
	}
	
	public String getSymbol() {
		return symbol;
	}
}