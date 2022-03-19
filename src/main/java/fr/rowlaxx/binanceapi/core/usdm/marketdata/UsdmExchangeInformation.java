package fr.rowlaxx.binanceapi.core.usdm.marketdata;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.exchangeinfos.ExchangeInformation;
import fr.rowlaxx.convertutils.MapKey;

public class UsdmExchangeInformation extends ExchangeInformation<UsdmSymbol> {
	private static final long serialVersionUID = -5298506133872695636L;

	//Variables
	private UsdmFuturesType futuresType;
	
	@MapKey(fieldName = "asset")
	private Map<String, UsdmAsset> assets;
	
	//Constructeurs
	public UsdmExchangeInformation(JSONObject response) {
		super(response);
	}
	
	//Getters
	public UsdmFuturesType getFuturesType() {
		return futuresType;
	}
	
	public Map<String, UsdmAsset> getAssets() {
		return assets;
	}
	
	public UsdmAsset getAsset(String asset) {
		return assets.get(asset);
	}
}