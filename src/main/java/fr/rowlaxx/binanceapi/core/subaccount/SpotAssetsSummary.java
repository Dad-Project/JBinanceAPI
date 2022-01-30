package fr.rowlaxx.binanceapi.core.subaccount;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.ManualValue;

public class SpotAssetsSummary extends JsavonObject {
	private static final long serialVersionUID = -2581919887556202886L;
	
	//Variables
	private double masterAccountTotalAsset;
	@ManualValue private Map<String, Double> totalAsset = new HashMap<>();
	private int totalCount;
	
	//Constructeurs
	public SpotAssetsSummary(JSONObject json) {
		super(json);
		for (Object o : json.getJSONArray("spotSubUserAssetBtcVoList"))
			totalAsset.put(
					((JSONObject)o).getString("email"), 
					((JSONObject)o).getDouble("totalAsset")
			);
	}
	
	//Getters
	public final double getMasterAccountTotalAsset() {
		return this.masterAccountTotalAsset;
	}
	
	public final Map<String, Double> getTotalAsset() {
		return this.totalAsset;
	}
	
	public final Double getTotalAsset(String email) {
		return this.totalAsset.get(email);
	}
	
	public final int getTotalCount() {
		return this.totalCount;
	}
}