package fr.rowlaxx.temp.blvtendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.blvtendpoints.getblvtinfo.CurrentBaskets;

import java.util.List;

import org.json.JSONObject;

public class GetBLVTInfo extends JSavONObject {
	private static final long serialVersionUID = -1469211921135121615L;
	
	//Variables
	private String basket;
	private List<CurrentBaskets> currentBaskets;
	private double dailyManagementFee;
	private double dailyPurchaseLimit;
	private double dailyRedeemLimit;
	private String description;
	private double fundingRate;
	private double nav;
	private double purchaseFeePct;
	private double realLeverage;
	private double redeemFeePct;
	private long timestamp;
	private double tokenIssued;
	private String tokenName;
	private String underlying;
	
	//Constructeurs
	public GetBLVTInfo(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getBasket() {
		return this.basket;
	}
	
	public final List<CurrentBaskets> getCurrentBaskets() {
		return this.currentBaskets;
	}
	
	public final double getDailyManagementFee() {
		return this.dailyManagementFee;
	}
	
	public final double getDailyPurchaseLimit() {
		return this.dailyPurchaseLimit;
	}
	
	public final double getDailyRedeemLimit() {
		return this.dailyRedeemLimit;
	}
	
	public final String getDescription() {
		return this.description;
	}
	
	public final double getFundingRate() {
		return this.fundingRate;
	}
	
	public final double getNav() {
		return this.nav;
	}
	
	public final double getPurchaseFeePct() {
		return this.purchaseFeePct;
	}
	
	public final double getRealLeverage() {
		return this.realLeverage;
	}
	
	public final double getRedeemFeePct() {
		return this.redeemFeePct;
	}
	
	public final long getTimestamp() {
		return this.timestamp;
	}
	
	public final double getTokenIssued() {
		return this.tokenIssued;
	}
	
	public final String getTokenName() {
		return this.tokenName;
	}
	
	public final String getUnderlying() {
		return this.underlying;
	}
}