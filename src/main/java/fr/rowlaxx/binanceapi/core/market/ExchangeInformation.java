package fr.rowlaxx.binanceapi.core.market;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.enums.Filters;
import fr.rowlaxx.binanceapi.enums.Filters.Type;
import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonMap;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public abstract class ExchangeInformation<T extends Symbol> extends BinanceResponseJSON {
	private static final long serialVersionUID = 8865485419600969411L;

	//Variables
	@JsonValue private List<RateLimit> rateLimits;
	@JsonValue private String timezone;
	@JsonValue private long serverTime;
	
	@JsonValue
	@JsonMap(key = "symbol")
	private Map<String, T> symbols;
	
	private Map<Filters, Filter> exchangeFilters;
	
	//Constructeurs
	public ExchangeInformation(JSONObject response) {
		super(response);
		final HashMap<Filters, Filter> filters = new HashMap<>();
		final JSONArray array = response.getJSONArray("exchangeFilters");
		JSONObject json;
		Filter exchangeFilter;
		for (int i = 0 ; i < array.length() ; i++) {
			json = array.getJSONObject(i);
			exchangeFilter = Filter.fromJson(json);
			filters.put(exchangeFilter.getFilterType(), exchangeFilter);
		}
		this.exchangeFilters = Collections.unmodifiableMap(filters);
	}
	
	//Getters
	public Map<Filters, Filter> getExchangeFilters() {
		return exchangeFilters;
	}
	
	public Filter getExchangeFilter(Filters filter) {
		if (filter == null)
			return null;
		if (filter.getType() == Type.EXCHANGE)
			return exchangeFilters.get(filter);
		throw new IllegalArgumentException("filter may be a EXCHANGE filter.");
	}
	
	public List<RateLimit> getRateLimits() {
		return rateLimits;
	}
	
	public long getServerTime() {
		return serverTime;
	}
	
	public Map<String, T> getSymbols() {
		return symbols;
	}
	
	public T getSymbol(String symbol) {
		return symbols.get(symbol);
	}
	
	public String getTimezone() {
		return timezone;
	}
}
