package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.MapKey;

import java.util.Map;

import org.json.JSONObject;

public class SubAccountsFuturesSummary extends JsavonObject {
	private static final long serialVersionUID = -3504303871191442718L;
	
	//Variables
	private String asset;
	@MapKey(fieldName = "email")
	private Map<String, AccountAsset> subAccountList;
	private double totalInitialMargin;
	private double totalMaintenanceMargin;
	private double totalMarginBalance;
	private double totalOpenOrderInitialMargin;
	private double totalPositionInitialMargin;
	private double totalUnrealizedProfit;
	private double totalWalletBalance;
	
	//Constructeurs
	public SubAccountsFuturesSummary(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final Map<String, AccountAsset> getSubAccountList() {
		return this.subAccountList;
	}
	
	public final double getTotalInitialMargin() {
		return this.totalInitialMargin;
	}
	
	public final double getTotalMaintenanceMargin() {
		return this.totalMaintenanceMargin;
	}
	
	public final double getTotalMarginBalance() {
		return this.totalMarginBalance;
	}
	
	public final double getTotalOpenOrderInitialMargin() {
		return this.totalOpenOrderInitialMargin;
	}
	
	public final double getTotalPositionInitialMargin() {
		return this.totalPositionInitialMargin;
	}
	
	public final double getTotalUnrealizedProfit() {
		return this.totalUnrealizedProfit;
	}
	
	public final double getTotalWalletBalance() {
		return this.totalWalletBalance;
	}
}