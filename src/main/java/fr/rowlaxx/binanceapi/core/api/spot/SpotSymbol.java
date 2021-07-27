package fr.rowlaxx.binanceapi.core.api.spot;

import java.util.Set;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.market.Symbol;

public class SpotSymbol extends Symbol<SpotOrderTypes> {
	private static final long serialVersionUID = 5107341988411255864L;

	//Permissions
	public static enum Permissions{SPOT, MARGIN}
	
	//Variables
	private boolean quoteOrderQtyMarketAllowed;
	private boolean isSpotTradingAllowed;
	private int quoteAssetPrecision;
	private int quoteCommissionPrecision;
	private boolean ocoAllowed;
	private boolean icebergAllowed;
	private boolean isMarginTradingAllowed;
	private int baseCommissionPrecision;
	private SpotSymbolStatus status;

	private Set<Permissions> permissions;
	
	//Constructeurs
	public SpotSymbol(JSONObject response) {
		super(response);
	}

	//Getters
	public boolean isQuoteOrderQtyMarketAllowed() {
		return quoteOrderQtyMarketAllowed;
	}

	public boolean isSpotTradingAllowed() {
		return isSpotTradingAllowed;
	}

	public int getQuoteAssetPrecision() {
		return quoteAssetPrecision;
	}

	public int getQuoteCommissionPrecision() {
		return quoteCommissionPrecision;
	}

	public boolean isOcoAllowed() {
		return ocoAllowed;
	}

	public boolean isIcebergAllowed() {
		return icebergAllowed;
	}

	public boolean isMarginTradingAllowed() {
		return isMarginTradingAllowed;
	}

	public int getBaseCommissionPrecision() {
		return baseCommissionPrecision;
	}

	public SpotSymbolStatus getStatus() {
		return status;
	}

	public Set<Permissions> getPermissions() {
		return permissions;
	}
}