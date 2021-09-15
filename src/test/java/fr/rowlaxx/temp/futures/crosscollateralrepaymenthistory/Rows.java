package fr.rowlaxx.temp.futures.crosscollateralrepaymenthistory;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Rows extends JSavONObject {
	private static final long serialVersionUID = -6003422166487470502L;
	
	//Variables
	private double amount;
	private String coin;
	private String collateralCoin;
	private long confirmedTime;
	private double price;
	private double releasedCollateral;
	private int repayCollateral;
	private long repayId;
	private String repayType;
	private String status;
	private long updateTime;
	
	//Constructeurs
	public Rows(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final long getConfirmedTime() {
		return this.confirmedTime;
	}
	
	public final double getPrice() {
		return this.price;
	}
	
	public final double getReleasedCollateral() {
		return this.releasedCollateral;
	}
	
	public final int getRepayCollateral() {
		return this.repayCollateral;
	}
	
	public final long getRepayId() {
		return this.repayId;
	}
	
	public final String getRepayType() {
		return this.repayType;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}