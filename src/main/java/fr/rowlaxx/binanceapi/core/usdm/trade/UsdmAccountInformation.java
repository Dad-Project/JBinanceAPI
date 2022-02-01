package fr.rowlaxx.binanceapi.core.usdm.trade;

import fr.rowlaxx.binanceapi.core.coinm.trade.UsdmAccountPosition;
import fr.rowlaxx.binanceapi.core.futures.trade.FutureAccountInformation;

import org.json.JSONObject;

public class UsdmAccountInformation extends FutureAccountInformation<UsdmAccountAsset, UsdmAccountPosition> {
	private static final long serialVersionUID = 2328437378415542856L;
	
	private double maxWithdrawAmount;
	private double availableBalance;
	private double totalCrossUnPnl;
	private double totalCrossWalletBalance;
	private double totalInitialMargin;
	private double totalMaintMargin;
	private double totalMarginBalance;
	private double totalOpenOrderInitialMargin;
	private double totalPositionInitialMargin;
	private double totalUnrealizedProfit;
	private double totalWalletBalance;
		
	//Constructeurs
	public UsdmAccountInformation(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAvailableBalance() {
		return this.availableBalance;
	}
	
	public final double getMaxWithdrawAmount() {
		return this.maxWithdrawAmount;
	}
	
	public final double getTotalCrossUnPnl() {
		return this.totalCrossUnPnl;
	}
	
	public final double getTotalCrossWalletBalance() {
		return this.totalCrossWalletBalance;
	}
	
	public final double getTotalInitialMargin() {
		return this.totalInitialMargin;
	}
	
	public final double getTotalMaintMargin() {
		return this.totalMaintMargin;
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