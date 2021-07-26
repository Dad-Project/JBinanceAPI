package fr.rowlaxx.binanceapi.core.api.bswap;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public abstract class Swap extends BinanceResponseJSON {
	private static final long serialVersionUID = 6692814588470013570L;
	
	//Variables
	@JsonValue private String quoteAsset;
	@JsonValue private String baseAsset;
	@JsonValue private double quoteQty;
	@JsonValue private double baseQty;
	@JsonValue private double price;
	@JsonValue private double fee;
	
	//Constructeurs
	public Swap(JSONObject response) {
		super(response);
	}
	
	//Getters
	public String getBaseAsset() {
		return baseAsset;
	}
	
	public double getBaseQty() {
		return baseQty;
	}
	
	public double getFee() {
		return fee;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getQuoteAsset() {
		return quoteAsset;
	}
	
	public double getQuoteQty() {
		return quoteQty;
	}
}
