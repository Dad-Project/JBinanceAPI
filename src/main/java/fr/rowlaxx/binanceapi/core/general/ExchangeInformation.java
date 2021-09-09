package fr.rowlaxx.binanceapi.core.general;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public abstract class ExchangeInformation<T extends Symbol> extends JSavONObject {
	private static final long serialVersionUID = -7707306277131875272L;
	
	//Variables
	@JOValue(path = {"/", "/data/"})
	private String timezone;
	@JOValue(path = {"/", "/data/"})
	private long serverTime;

	//Constructeurs
	public ExchangeInformation(JSONObject json) {
		super(json);
	}
	
	//Méthodes abstraitesd
	public abstract Map<String, T> getSymbols();
	
	//Getters
	public String getTimezone() {
		return timezone;
	}
	
	public long getServerTime() {
		return serverTime;
	}
	
	public T getSymbol(String symbol) {
		return getSymbols().get(symbol);
	}
}