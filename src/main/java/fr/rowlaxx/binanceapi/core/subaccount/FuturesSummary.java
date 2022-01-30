package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;
import fr.rowlaxx.jsavon.annotations.MapKey;

import java.util.Map;

import org.json.JSONObject;

public class FuturesSummary extends JsavonObject {
	private static final long serialVersionUID = -3504303871191442718L;
	
	//Variables
	private String asset;
	@MapKey(fieldName = "email") private Map<String, FuturesUserAsset> subAccountList;
	@JOValue(mandatory = false) private Double totalInitialMargin;
	@JOValue(mandatory = false) private Double totalMaintenanceMargin;
	private double totalMarginBalance;
	@JOValue(mandatory = false) private Double totalOpenOrderInitialMargin;
	@JOValue(mandatory = false) private Double totalPositionInitialMargin;
	private double totalUnrealizedProfit;
	private double totalWalletBalance;
	
	//Constructeurs
	public FuturesSummary(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final Map<String, FuturesUserAsset> getSubAccountList() {
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