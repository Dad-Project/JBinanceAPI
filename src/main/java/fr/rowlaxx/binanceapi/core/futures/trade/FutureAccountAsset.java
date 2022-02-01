package fr.rowlaxx.binanceapi.core.futures.trade;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class FutureAccountAsset extends JsavonObject {
	private static final long serialVersionUID = 596984720475730328L;

	private String asset;
	private double availableBalance;
	private double crossUnPnl;
	private double crossWalletBalance;
	private double initialMargin;
	private double maintMargin;
	private double marginBalance;
	private double maxWithdrawAmount;
	private double openOrderInitialMargin;
	private double positionInitialMargin;
	private double unrealizedProfit;
	private double walletBalance;
	
	public FutureAccountAsset(JSONObject json) {
		super(json);
	}
	
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getAvailableBalance() {
		return this.availableBalance;
	}
	
	public final double getCrossUnPnl() {
		return this.crossUnPnl;
	}
	
	public final double getCrossWalletBalance() {
		return this.crossWalletBalance;
	}
	
	public final double getInitialMargin() {
		return this.initialMargin;
	}
	
	public final double getMaintMargin() {
		return this.maintMargin;
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
