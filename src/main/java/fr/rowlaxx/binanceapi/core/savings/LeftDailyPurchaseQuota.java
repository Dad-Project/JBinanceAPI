package fr.rowlaxx.binanceapi.core.savings;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class LeftDailyPurchaseQuota extends JSavONObject {
	private static final long serialVersionUID = 464566317675746179L;
	
	//Variables
	private String asset;
	private double leftQuota;
	
	//Constructeurs
	public LeftDailyPurchaseQuota(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getLeftQuota() {
		return this.leftQuota;
	}
}