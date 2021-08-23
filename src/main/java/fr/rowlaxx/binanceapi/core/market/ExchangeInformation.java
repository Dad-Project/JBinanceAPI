package fr.rowlaxx.binanceapi.core.market;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.market.filter.ExchangeFilter;
import fr.rowlaxx.binanceapi.core.market.filter.Filter;
import fr.rowlaxx.binanceapi.core.market.filter.Filters;
import fr.rowlaxx.binanceapi.core.market.filter.Filters.Type;
import fr.rowlaxx.binanceapi.exception.BinanceException;
import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public abstract class ExchangeInformation<T extends Symbol> extends BinanceResponseJSON {
	private static final long serialVersionUID = 8865485419600969411L;

	//Variables
	@JsonValue private List<RateLimit> rateLimits;
	@JsonValue private String timezone;
	@JsonValue private long serverTime;
	
	private Map<String, T> symbols;
	private Map<Filters, ExchangeFilter> exchangeFilters;
	
	//Constructeurs
	public ExchangeInformation(JSONObject response) {
		super(response);
		JSONObject json;
		
		final HashMap<Filters, ExchangeFilter> filters = new HashMap<>();
		final JSONArray array = response.getJSONArray("exchangeFilters");
		Filter exchangeFilter;
		for (int i = 0 ; i < array.length() ; i++) {
			json = array.getJSONObject(i);
			exchangeFilter = Filter.fromJson(json);
			filters.put(exchangeFilter.getFilterType(), (ExchangeFilter) exchangeFilter);
		}
		this.exchangeFilters = Collections.unmodifiableMap(filters);
	
		final HashMap<String, T> symbols = new HashMap<>();
		final JSONArray symbolsArray = response.getJSONArray("symbols");
		@SuppressWarnings("unchecked")
		final Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
		try {
			final Constructor<T> constructor = clazz.getConstructor(JSONObject.class);
			
			T symbol;
			for (int i = 0 ; i < symbolsArray.length() ; i++) {
				json = symbolsArray.getJSONObject(i);
				symbol = constructor.newInstance(json);
				symbols.put(symbol.getSymbol(), symbol);
			}
			
			this.symbols = Collections.unmodifiableMap(symbols);
		}catch(Exception e) {
			e.printStackTrace();
			throw new BinanceException(e.getMessage());
		}
	}
	
	//Getters
	public Map<Filters, ExchangeFilter> getExchangeFilters() {
		return exchangeFilters;
	}
	
	public ExchangeFilter getExchangeFilter(Filters filter) {
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