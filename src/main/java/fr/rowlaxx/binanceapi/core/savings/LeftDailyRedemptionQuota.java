package fr.rowlaxx.binanceapi.core.savings;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class LeftDailyRedemptionQuota extends JsavonObject {
	private static final long serialVersionUID = -1595989675358798941L;
	
	//Variables
	private String asset;
	private double dailyQuota;
	private double leftQuota;
	private double minRedemptionAmount;
	
	//Constructeurs
	public LeftDailyRedemptionQuota(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getDailyQuota() {
		return this.dailyQuota;
	}
	
	public final double getLeftQuota() {
		return this.leftQuota;
	}
	
	public final double getMinRedemptionAmount() {
		return this.minRedemptionAmount;
	}
}