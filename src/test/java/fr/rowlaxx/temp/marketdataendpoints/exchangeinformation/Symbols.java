package fr.rowlaxx.temp.marketdataendpoints.exchangeinformation;

import fr.rowlaxx.jsavon.JSavONObject;

import java.util.List;

import org.json.JSONObject;

public class Symbols extends JSavONObject {
	private static final long serialVersionUID = 6610584233518117481L;
	
	//Variables
	private String baseAsset;
	private int baseAssetPrecision;
	private List<Object> filters;
	private boolean icebergAllowed;
	private boolean isMarginTradingAllowed;
	private boolean isSpotTradingAllowed;
	private boolean ocoAllowed;
	private List<String> orderTypes;
	private List<String> permissions;
	private String quoteAsset;
	private int quoteAssetPrecision;
	private int quotePrecision;
	private String status;
	private String symbol;
	
	//Constructeurs
	public Symbols(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getBaseAsset() {
		return this.baseAsset;
	}
	
	public final int getBaseAssetPrecision() {
		return this.baseAssetPrecision;
	}
	
	public final List<Object> getFilters() {
		return this.filters;
	}
	
	public final boolean isIcebergAllowed() {
		return this.icebergAllowed;
	}
	
	public final boolean isMarginTradingAllowed() {
		return this.isMarginTradingAllowed;
	}
	
	public final boolean isSpotTradingAllowed() {
		return this.isSpotTradingAllowed;
	}
	
	public final boolean isOcoAllowed() {
		return this.ocoAllowed;
	}
	
	public final List<String> getOrderTypes() {
		return this.orderTypes;
	}
	
	public final List<String> getPermissions() {
		return this.permissions;
	}
	
	public final String getQuoteAsset() {
		return this.quoteAsset;
	}
	
	public final int getQuoteAssetPrecision() {
		return this.quoteAssetPrecision;
	}
	
	public final int getQuotePrecision() {
		return this.quotePrecision;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}