package fr.rowlaxx.binanceapi.core.general.usdm;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class Asset extends JSavONObject {
	private static final long serialVersionUID = -8867757164767750187L;

	//Variables
	@JOValue private double autoAssetExchange;
	@JOValue private String asset;
	@JOValue private boolean marginAvailable;
	
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
