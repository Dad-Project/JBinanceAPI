package fr.rowlaxx.binanceapi.core.exchangeinfos;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public abstract class SimpleExchangeInformation<T extends SimpleSymbol> extends JsavonObject {
	private static final long serialVersionUID = -7707306277131875272L;
	
	//Variables
	@JOValue(path = {"/", "/data/"})
	private String timezone;
	@JOValue(path = {"/", "/data/"})
	private long serverTime;

	//Constructeurs
	public SimpleExchangeInformation(JSONObject json) {
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