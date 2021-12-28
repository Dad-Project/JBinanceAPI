package fr.rowlaxx.binanceapi.core.subaccount;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class SubAccountSpotSummary extends JsavonObject {
	private static final long serialVersionUID = -2581919887556202886L;
	
	//Variables
	private double masterAccountTotalAsset;
	private Map<String, SubUserSpotAsset> spotSubUserAssetBtcVoList;
	private int totalCount;
	
	//Constructeurs
	public SubAccountSpotSummary(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getMasterAccountTotalAsset() {
		return this.masterAccountTotalAsset;
	}
	
	public final Map<String, SubUserSpotAsset> getSubUserSpotAssets() {
		return this.spotSubUserAssetBtcVoList;
	}
	
	public final SubUserSpotAsset getSubUserSpotAsset(String email) {
		return this.spotSubUserAssetBtcVoList.get(email);
	}
	
	public final int getTotalCount() {
		return this.totalCount;
	}
}