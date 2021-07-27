package fr.rowlaxx.binanceapi.core.api.usdm;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class Asset extends BinanceResponseJSON {
	private static final long serialVersionUID = -8867757164767750187L;

	//Variables
	@JsonValue private double autoAssetExchange;
	@JsonValue private String asset;
	@JsonValue private boolean marginAvailable;
	
	//Constructeurs
	public Asset(JSONObject response) {
		super(response);
	}
	
	//Getters
	public String getAsset() {
		return asset;
	}
	
	public double getAutoAssetExchange() {
		return autoAssetExchange;
	}
	
	public boolean isMarginAvailable() {
		return marginAvailable;
	}
}
