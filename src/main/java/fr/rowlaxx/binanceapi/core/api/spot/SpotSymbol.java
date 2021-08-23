package fr.rowlaxx.binanceapi.core.api.spot;

import java.util.Set;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.market.Symbol;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class SpotSymbol extends Symbol {
	private static final long serialVersionUID = 5107341988411255864L;

	//Permissions
	public static enum Permissions{SPOT, MARGIN, LEVERAGED}
	
	//Variables
	@JsonValue private Set<SpotOrderTypes> orderTypes;
	@JsonValue private boolean quoteOrderQtyMarketAllowed;
	@JsonValue private boolean isSpotTradingAllowed;
	@JsonValue private int quoteAssetPrecision;
	@JsonValue private int quoteCommissionPrecision;
	@JsonValue private boolean ocoAllowed;
	@JsonValue private boolean icebergAllowed;
	@JsonValue private boolean isMarginTradingAllowed;
	@JsonValue private int baseCommissionPrecision;
	@JsonValue private SpotSymbolStatus status;
	@JsonValue private Set<Permissions> permissions;
	
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
	
	public Set<SpotOrderTypes> getOrderTypes() {
		return orderTypes;
	}
	
	public boolean hasOrderType(SpotOrderTypes spotOrderTypes) {
		return orderTypes.contains(spotOrderTypes);
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