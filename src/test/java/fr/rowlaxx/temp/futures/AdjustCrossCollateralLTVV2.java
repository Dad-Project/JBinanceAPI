package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class AdjustCrossCollateralLTVV2 extends JSavONObject {
	private static final long serialVersionUID = -7246380880745070984L;
	
	//Variables
	private double amount;
	private String collateralCoin;
	private String direction;
	private String loanCoin;
	private long time;
	
	//Constructeurs
	public AdjustCrossCollateralLTVV2(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final String getDirection() {
		return this.direction;
	}
	
	public final String getLoanCoin() {
		return this.loanCoin;
	}
	
	public final long getTime() {
		return this.time;
	}
}