package fr.rowlaxx.binanceapi.core.margin;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.MapKey;

public class IsolatedMarginAccount extends JsavonObject {
	private static final long serialVersionUID = 8230241261710009584L;
	
	//Variables
	@MapKey(fieldName = "symbol")
	private Map<String, MarginUserAsset> assets;
	private double totalAssetOfBtc;
	private double totalLiabilityOfBtc;
	private double totalNetAssetOfBtc;
	
	//Constructeurs
	public IsolatedMarginAccount(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Map<String, MarginUserAsset> getAssets() {
		return assets;
	}
	
	public final MarginUserAsset getAsset(String symbol) {
		return assets.get(symbol);
	}
	
	public final double getTotalAssetOfBtc() {
		return totalAssetOfBtc;
	}
	
	public final double getTotalLiabilityOfBtc() {
		return totalLiabilityOfBtc;
	}
	
	public final double getTotalNetAssetOfBtc() {
		return totalNetAssetOfBtc;
	}
}
