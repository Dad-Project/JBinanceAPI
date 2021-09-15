package fr.rowlaxx.temp.savingsendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class GetFlexibleProductList extends JSavONObject {
	private static final long serialVersionUID = 8342258680470277251L;
	
	//Variables
	private String asset;
	private double avgAnnualInterestRate;
	private boolean canPurchase;
	private boolean canRedeem;
	private double dailyInterestPerThousand;
	private boolean featured;
	private double minPurchaseAmount;
	private String productId;
	private double purchasedAmount;
	private String status;
	private double upLimit;
	private double upLimitPerUser;
	
	//Constructeurs
	public GetFlexibleProductList(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getAvgAnnualInterestRate() {
		return this.avgAnnualInterestRate;
	}
	
	public final boolean isCanPurchase() {
		return this.canPurchase;
	}
	
	public final boolean isCanRedeem() {
		return this.canRedeem;
	}
	
	public final double getDailyInterestPerThousand() {
		return this.dailyInterestPerThousand;
	}
	
	public final boolean isFeatured() {
		return this.featured;
	}
	
	public final double getMinPurchaseAmount() {
		return this.minPurchaseAmount;
	}
	
	public final String getProductId() {
		return this.productId;
	}
	
	public final double getPurchasedAmount() {
		return this.purchasedAmount;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final double getUpLimit() {
		return this.upLimit;
	}
	
	public final double getUpLimitPerUser() {
		return this.upLimitPerUser;
	}
}