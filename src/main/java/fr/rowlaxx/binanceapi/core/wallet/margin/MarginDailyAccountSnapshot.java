package fr.rowlaxx.binanceapi.core.wallet.margin;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.wallet.DailyAccountSnapshot;
import fr.rowlaxx.jsavon.annotations.MapKey;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class MarginDailyAccountSnapshot extends DailyAccountSnapshot {
	private static final long serialVersionUID = -628167293791049109L;

	//Variables
	@JOValue(path = "data") private double marginLevel, totalAssetOfBtc, totalLiabilityOfBtc, totalNetAssetOfBtc;
	@JOValue(path = "data")
	@MapKey(fieldName = "asset")
	private Map<String, UserAsset> userAssets;
	
	//Constructeurs
	public MarginDailyAccountSnapshot(JSONObject json) {
		super(json);
	}
	
	//Getters
	public double getTotalAssetOfBtc() {
		return totalAssetOfBtc;
	}
	
	public double getTotalLiabilityOfBtc() {
		return totalLiabilityOfBtc;
	}
	
	public Map<String, UserAsset> getUserAssets() {
		return userAssets;
	}
	
	public double getTotalNetAssetOfBtc() {
		return totalNetAssetOfBtc;
	}
	
	public double getMarginLevel() {
		return marginLevel;
	}
}
