package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.querysubaccountspotassetssummary.SpotSubUserAssetBtcVoList;

import java.util.List;

import org.json.JSONObject;

public class QuerySubaccountSpotAssetsSummary extends JSavONObject {
	private static final long serialVersionUID = -2581919887556202886L;
	
	//Variables
	private double masterAccountTotalAsset;
	private List<SpotSubUserAssetBtcVoList> spotSubUserAssetBtcVoList;
	private int totalCount;
	
	//Constructeurs
	public QuerySubaccountSpotAssetsSummary(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getMasterAccountTotalAsset() {
		return this.masterAccountTotalAsset;
	}
	
	public final List<SpotSubUserAssetBtcVoList> getSpotSubUserAssetBtcVoList() {
		return this.spotSubUserAssetBtcVoList;
	}
	
	public final int getTotalCount() {
		return this.totalCount;
	}
}