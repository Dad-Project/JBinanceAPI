package fr.rowlaxx.temp.marketdataendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.marketdataendpoints.exchangeinformation.RateLimits;
import fr.rowlaxx.temp.marketdataendpoints.exchangeinformation.Symbols;

import java.util.List;

import org.json.JSONObject;

public class ExchangeInformation extends JSavONObject {
	private static final long serialVersionUID = -8243402992229664577L;
	
	//Variables
	private List<Object> exchangeFilters;
	private List<RateLimits> rateLimits;
	private long serverTime;
	private List<Symbols> symbols;
	private String timezone;
	
	//Constructeurs
	public ExchangeInformation(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<Object> getExchangeFilters() {
		return this.exchangeFilters;
	}
	
	public final List<RateLimits> getRateLimits() {
		return this.rateLimits;
	}
	
	public final long getServerTime() {
		return this.serverTime;
	}
	
	public final List<Symbols> getSymbols() {
		return this.symbols;
	}
	
	public final String getTimezone() {
		return this.timezone;
	}
}