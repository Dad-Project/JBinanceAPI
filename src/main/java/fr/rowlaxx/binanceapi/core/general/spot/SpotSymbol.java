package fr.rowlaxx.binanceapi.core.general.spot;

import java.util.Set;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.SimpleSymbol;
import fr.rowlaxx.binanceapi.core.order.spot.SpotOrderTypes;

public class SpotSymbol extends SimpleSymbol<SpotOrderTypes> {
	private static final long serialVersionUID = 1381142129152963029L;

	//Variables
	private Set<SpotPermissions> permissions;
	private SpotSymbolStatus status;
	private int baseCommissionPrecision;
	private boolean isMarginTradingAllowed;
	private boolean icebergAllowed;
	private boolean ocoAllowed;
	private boolean isSpotTradingAllowed;
	private boolean quoteOrderQtyMarketAllowed;
	private int quoteAssetPrecision;
	private int quoteCommissionPrecision;
	
	//Constructeurs
	public SpotSymbol(JSONObject response) {
		super(response);
	}
	
	//Getter
	public Set<SpotPermissions> getPermissions() {
		return permissions;
	}

	public int getBaseCommissionPrecision() {
		return baseCommissionPrecision;
	}
	
	public int getQuoteAssetPrecision() {
		return quoteAssetPrecision;
	}
	
	public int getQuoteCommissionPrecision() {
		return quoteCommissionPrecision;
	}
	
	public SpotSymbolStatus getStatus() {
		return status;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isIcebergAllowed() {
		return icebergAllowed;
	}
	
	public boolean isMarginTradingAllowed() {
		return isMarginTradingAllowed;
	}
	
	public boolean isOcoAllowed() {
		return ocoAllowed;
	}
	
	public boolean isQuoteOrderQtyMarketAllowed() {
		return quoteOrderQtyMarketAllowed;
	}
	
	public boolean isSpotTradingAllowed() {
		return isSpotTradingAllowed;
	}
}
