package fr.rowlaxx.binanceapi.core.market;

import java.util.Set;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.enums.OrderTypes;
import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;

public abstract class Symbol extends BinanceResponseJSON {
	private static final long serialVersionUID = -6654992662838138776L;

	//Variables
	private String symbol;
	private String baseAsset;
	private String quoteAsset;
	private int baseAssetPrecision;
	private Filter filters;
	private int quotePrecision;
	private Set<OrderTypes> orderTypes;
	
	//Constructeurs
	public Symbol(JSONObject response) {
		super(response);
	}
	
	//Getters
	public String getBaseAsset() {
		return baseAsset;
	}
	
	public int getBaseAssetPrecision() {
		return baseAssetPrecision;
	}
	
	public Filter getFilters() {
		return filters;
	}
	
	public Set<OrderTypes> getOrderTypes() {
		return orderTypes;
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