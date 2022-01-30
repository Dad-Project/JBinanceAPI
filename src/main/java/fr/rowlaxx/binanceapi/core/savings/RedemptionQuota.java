package fr.rowlaxx.binanceapi.core.savings;

import org.json.JSONObject;

public class RedemptionQuota extends Quota {
	private static final long serialVersionUID = -1595989675358798941L;
	
	//Variables
	private double dailyQuota;
	private double minRedemptionAmount;
	
	//Constructeurs
	public RedemptionQuota(JSONObject json) {
		super(json);
	}
	
	//Getters	
	public final double getDailyQuota() {
		return this.dailyQuota;
	}
	
	public final double getMinRedemptionAmount() {
		return this.minRedemptionAmount;
	}
}