package fr.rowlaxx.binanceapi.core.api.blvt;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonMap;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class BlvtInfo extends BinanceResponseJSON {
	private static final long serialVersionUID = 8928020183674399553L;
	
	//Variables
	@JsonValue private String basket;
	@JsonValue private double nav;
	@JsonValue private double redeemFeePct;
	@JsonValue private double realLeverage;
	@JsonValue private String tokenName;
	@JsonValue private String description;
	@JsonValue private String underlying;
	@JsonValue private double dailyManagementFee;
	@JsonValue private double dailyRedeemLimit;
	@JsonValue private double purchaseFeePct;
	@JsonValue private double tokenIssued;
	@JsonValue private double dailyPurchaseLimit;
	@JsonValue private double fundingRate;
	@JsonValue private long timestamp;
	
	@JsonValue
	@JsonMap(key = "symbol") 
	private Map<String, CurrentBasket> currentBaskets;
	
	//Constructeurs
	public BlvtInfo(JSONObject response) {
		super(response);
	}

	//Getters
	public String getBasket() {
		return basket;
	}
	
	public double getNav() {
		return nav;
	}
	
	public double getRealLeverage() {
		return realLeverage;
	}
	
	public double getRedeemFeePct() {
		return redeemFeePct;
	}
	
	public double getDailyManagementFee() {
		return dailyManagementFee;
	}
	
	public double getDailyPurchaseLimit() {
		return dailyPurchaseLimit;
	}
	
	public double getDailyRedeemLimit() {
		return dailyRedeemLimit;
	}
	
	public String getDescription() {
		return description;
	}
	
	public double getPurchaseFeePct() {
		return purchaseFeePct;
	}
	
	public double getFundingRate() {
		return fundingRate;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public double getTokenIssued() {
		return tokenIssued;
	}
	
	public String getTokenName() {
		return tokenName;
	}
	
	public String getUnderlying() {
		return underlying;
	}
	
	public Map<String, CurrentBasket> getCurrentBaskets() {
		return currentBaskets;
	}
	
	//CurrentBasket
	public static class CurrentBasket extends BinanceResponseJSON {
		private static final long serialVersionUID = 3348945810283969397L;
		
		//Variables
		@JsonValue private String symbol;
		@JsonValue private double amount;
		@JsonValue private double notionalValue;
		
		//Constructeurs
		public CurrentBasket(JSONObject response) {
			super(response);
		}
		
		//Getters
		public double getAmount() {
			return amount;
		}
		
		public double getNotionalValue() {
			return notionalValue;
		}
		
		public String getSymbol() {
			return symbol;
		}
	}
}
