package fr.rowlaxx.binanceapi.core.future;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class AdjustCrossCollateral extends JsavonObject {
	private static final long serialVersionUID = -7246380880745070984L;
	
	//Variables
	private double amount;
	private String collateralCoin;
	private Direction direction;
	@JOValue(mandatory = false)
	private String loanCoin;
	@JOValue(key = {"time", "adjustTime"})
	private long time;
	
	//Constructeurs
	public AdjustCrossCollateral(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final Direction getDirection() {
		return this.direction;
	}
	
	public final String getLoanCoin() {
		return this.loanCoin;
	}
	
	public final long getTime() {
		return this.time;
	}
}