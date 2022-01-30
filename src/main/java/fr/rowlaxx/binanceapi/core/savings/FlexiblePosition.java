package fr.rowlaxx.binanceapi.core.savings;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class FlexiblePosition extends JsavonObject {
	private static final long serialVersionUID = -627588028410615745L;
	
	//Variables
	private double annualInterestRate;
	private String asset;
	private double avgAnnualInterestRate;
	private boolean canRedeem;
	private double dailyInterestRate;
	private double freeAmount;
	private double freezeAmount;
	private double lockedAmount;
	private String productId;
	private String productName;
	private double redeemingAmount;
	private double todayPurchasedAmount;
	private double totalAmount;
	private double totalInterest;
	
	//Constructeurs
	public FlexiblePosition(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAnnualInterestRate() {
		return this.annualInterestRate;
	}
	
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getAvgAnnualInterestRate() {
		return this.avgAnnualInterestRate;
	}
	
	public final boolean isCanRedeem() {
		return this.canRedeem;
	}
	
	public final double getDailyInterestRate() {
		return this.dailyInterestRate;
	}
	
	public final double getFreeAmount() {
		return this.freeAmount;
	}
	
	public final double getFreezeAmount() {
		return this.freezeAmount;
	}
	
	public final double getLockedAmount() {
		return this.lockedAmount;
	}
	
	public final String getProductId() {
		return this.productId;
	}
	
	public final String getProductName() {
		return this.productName;
	}
	
	public final double getRedeemingAmount() {
		return this.redeemingAmount;
	}
	
	public final double getTodayPurchasedAmount() {
		return this.todayPurchasedAmount;
	}
	
	public final double getTotalAmount() {
		return this.totalAmount;
	}
	
	public final double getTotalInterest() {
		return this.totalInterest;
	}
}