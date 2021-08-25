package fr.rowlaxx.binanceapi.core.market;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class SymbolPriceTicker extends BinanceResponseJSON{

	@JsonValue private String symbol;
	@JsonValue private double price;
	
	public SymbolPriceTicker(JSONObject response) {
		super(response);
	}
	
	public String getSymbol() {
		return symbol;
	}

	public double getPrice() {
		return price;
	}
}
