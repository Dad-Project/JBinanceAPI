package fr.rowlaxx.binanceapi.core.general.usdm;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.SimpleExchangeInformation;
import fr.rowlaxx.jsavon.annotations.MapKey;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class UsdmExchangeInformation extends SimpleExchangeInformation<UsdmSymbol> {
	private static final long serialVersionUID = -5298506133872695636L;

	//Variables
	@JOValue private UsdmFuturesType futuresType;
	
	@JOValue 
	@MapKey(fieldName = "asset")
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