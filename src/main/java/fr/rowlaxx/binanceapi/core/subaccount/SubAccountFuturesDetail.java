package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;
import fr.rowlaxx.jsavon.annotations.MapKey;
import java.util.Map;

import org.json.JSONObject;

public class SubAccountFuturesDetail extends JsavonObject {
	private static final long serialVersionUID = 1354381943294048558L;
	
	//Variables
	@JOValue(mandatory = false)
	private String asset;
	@MapKey(fieldName = "asset")
	private Map<String, Asset> assets;
	private boolean canDeposit;
	private boolean canTrade;
	private boolean canWithdraw;
	private String email;
	private int feeTier;
	private double maxWithdrawAmount;
	private double totalInitialMargin;
	private double totalMaintenanceMargin;
	private double totalMarginBalance;
	private double totalOpenOrderInitialMargin;
	private double totalPositionInitialMargin;
	private double totalUnrealizedProfit;
	private double totalWalletBalance;
	private long updateTime;
	
	//Constructeurs
	public SubAccountFuturesDetail(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final Map<String, Asset> getAssets() {
		return this.assets;
	}
	
	public final Asset getAsset(String name) {
		return this.assets.get(name);
	}
	
	public final boolean isCanDeposit() {
		return this.canDeposit;
	}
	
	public final boolean isCanTrade() {
		return this.canTrade;
	}
	
	public final boolean isCanWithdraw() {
		return this.canWithdraw;
	}
	
	public final String getEmail() {
		return this.email;
	}
	
	public final int getFeeTier() {
		return this.feeTier;
	}
	
	public final double getMaxWithdrawAmount() {
		return this.maxWithdrawAmount;
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
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}