package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Asset extends JSavONObject {
	private static final long serialVersionUID = 3273517312571081115L;
	
	//Variables
	private String asset;
	private double initialMargin;
	private double maintenanceMargin;
	private double marginBalance;
	private double maxWithdrawAmount;
	private double openOrderInitialMargin;
	private double positionInitialMargin;
	private double unrealizedProfit;
	private double walletBalance;
	
	//Constructeurs
	public Asset(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getInitialMargin() {
		return this.initialMargin;
	}
	
	public final double getMaintenanceMargin() {
		return this.maintenanceMargin;
	}
	
	public final double getMarginBalance() {
		return this.marginBalance;
	}
	
	public final double getMaxWithdrawAmount() {
		return this.maxWithdrawAmount;
	}
	
	public final double getOpenOrderInitialMargin() {
		return this.openOrderInitialMargin;
	}
	
	public final double getPositionInitialMargin() {
		return this.positionInitialMargin;
	}
	
	public final double getUnrealizedProfit() {
		return this.unrealizedProfit;
	}
	
	public final double getWalletBalance() {
		return this.walletBalance;
	}
}