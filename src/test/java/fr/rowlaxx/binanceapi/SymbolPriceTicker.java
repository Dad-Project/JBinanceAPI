package fr.rowlaxx.binanceapi;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class SymbolPriceTicker extends BinanceResponseJSON {

	@JsonValue private String symbol;
	@JsonValue private double price;
	
	public String getSymbol() {
		return symbol;
	}

	public double getPrice() {
		return price;
	}

	public SymbolPriceTicker(JSONObject response) {
		super(response);
	}

}
