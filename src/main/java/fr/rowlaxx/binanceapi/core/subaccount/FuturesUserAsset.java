package fr.rowlaxx.binanceapi.core.subaccount;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class FuturesUserAsset extends JsavonObject {
	private static final long serialVersionUID = -3948375796754374256L;
	
	//Variables
	private String asset;
	private String email;
	@JOValue(mandatory = false) private Double totalInitialMargin;
	@JOValue(mandatory = false) private Double totalMaintenanceMargin;
	private double totalMarginBalance;
	@JOValue(mandatory = false) private Double totalOpenOrderInitialMargin;
	@JOValue(mandatory = false) private Double totalPositionInitialMargin;
	private double totalUnrealizedProfit;
	private double totalWalletBalance;
	
	//Constructeurs
	public FuturesUserAsset(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final String getEmail() {
		return this.email;
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