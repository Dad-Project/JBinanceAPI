package fr.rowlaxx.temp.futures.adjustcrosscollateralltvhistory;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Rows extends JSavONObject {
	private static final long serialVersionUID = -7808659684934114456L;
	
	//Variables
	private long adjustTime;
	private double afterCollateralRate;
	private double amount;
	private String coin;
	private String collateralCoin;
	private String direction;
	private double preCollateralRate;
	private String status;
	
	//Constructeurs
	public Rows(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getAdjustTime() {
		return this.adjustTime;
	}
	
	public final double getAfterCollateralRate() {
		return this.afterCollateralRate;
	}
	
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final String getDirection() {
		return this.direction;
	}
	
	public final double getPreCollateralRate() {
		return this.preCollateralRate;
	}
	
	public final String getStatus() {
		return this.status;
	}
}