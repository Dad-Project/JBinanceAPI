package fr.rowlaxx.binanceapi.core.market;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonMap;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public abstract class ExchangeInformation<T extends Symbol> extends BinanceResponseJSON {
	private static final long serialVersionUID = 8865485419600969411L;

	//Variables
	@JsonValue private List<RateLimit> rateLimits;
	@JsonValue private List<String> exchangeFilters;
	@JsonValue private String timezone;
	@JsonValue private long serverTime;
	
	@JsonValue
	@JsonMap(key = "symbol")
	private Map<String, T> symbols;
	
	//Constructeurs
	public ExchangeInformation(JSONObject response) {
		super(response);
	}
	
	//Getters
	public List<String> getExchangeFilters() {
		return exchangeFilters;
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
	
	public String getTimezone() {
		return timezone;
	}
}
