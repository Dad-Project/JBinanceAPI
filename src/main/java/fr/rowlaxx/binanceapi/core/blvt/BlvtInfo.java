package fr.rowlaxx.binanceapi.core.blvt;

import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class BlvtInfo extends JsavonObject {
	private static final long serialVersionUID = -1469211921135121615L;
	
	//Variables
	private String basket;
	private List<Basket> currentBaskets;
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
	public BlvtInfo(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getBasket() {
		return this.basket;
	}
	
	public final List<Basket> getCurrentBaskets() {
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