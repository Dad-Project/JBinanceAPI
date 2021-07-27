package fr.rowlaxx.binanceapi.core.api.usdm;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonMap;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class UsdmExchangeInformation extends UsdmSymbol {
	private static final long serialVersionUID = -5298506133872695636L;

	//Variables
	@JsonValue private UsdmFuturesType futuresType;
	
	@JsonValue 
	@JsonMap(key = "asset")
	private Map<String, Asset> assets;
	
	//Constructeurs
	public UsdmExchangeInformation(JSONObject response) {
		super(response);
	}
	
	//Getters
	public UsdmFuturesType getFuturesType() {
		return futuresType;
	}
	
	public Map<String, Asset> getAssets() {
		return assets;
	}
	
	public Asset getAsset(String asset) {
		return assets.get(asset);
	}
}