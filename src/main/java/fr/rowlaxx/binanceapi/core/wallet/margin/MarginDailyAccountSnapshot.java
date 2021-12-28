package fr.rowlaxx.binanceapi.core.wallet.margin;

import fr.rowlaxx.binanceapi.core.wallet.DailyAccountSnapshot;
import fr.rowlaxx.jsavon.annotations.JOValue;
import fr.rowlaxx.jsavon.annotations.MapKey;

import java.util.Map;

import org.json.JSONObject;

public class MarginDailyAccountSnapshot extends DailyAccountSnapshot {
	private static final long serialVersionUID = -7974718376590612474L;
	
	//Variables
	@JOValue(path = "data", mandatory = false) 
	private Double marginLevel;
	@JOValue(path = "data") 
	private double totalAssetOfBtc;
	@JOValue(path = "data") 
	private double totalLiabilityOfBtc;
	@JOValue(path = "data") 
	private double totalNetAssetOfBtc;
	
	@JOValue(path = "data") 
	@MapKey(fieldName = "asset")
	private Map<String, UserAsset> userAssets;
	
	//Constructeurs
	public MarginDailyAccountSnapshot(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getMarginLevel() {
		return this.marginLevel;
	}
	
	public final double getTotalAssetOfBtc() {
		return this.totalAssetOfBtc;
	}
	
	public final double getTotalLiabilityOfBtc() {
		return this.totalLiabilityOfBtc;
	}
	
	public final double getTotalNetAssetOfBtc() {
		return this.totalNetAssetOfBtc;
	}
	
	public final Map<String, UserAsset> getUserAssets() {
		return this.userAssets;
	}
	
	public final UserAsset getUserAsset(String asset) {
		return this.userAssets.get(asset);
	}
}