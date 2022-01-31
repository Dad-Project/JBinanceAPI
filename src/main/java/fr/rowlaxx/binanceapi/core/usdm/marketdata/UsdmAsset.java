package fr.rowlaxx.binanceapi.core.usdm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class UsdmAsset extends JsavonObject {
	private static final long serialVersionUID = -8867757164767750187L;

	//Variables
	private double autoAssetExchange;
	private String asset;
	private boolean marginAvailable;
	
	//Constructeurs
	public UsdmAsset(JSONObject response) {
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
