package fr.rowlaxx.binanceapi.core.future;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.order.OrderStatus;

public class RepayRecord extends Repay {
	private static final long serialVersionUID = 3496267355855391860L;

	//Variables
	private String repayType;
	private double releasedCollateral;
	private double price;
	private double repayCollateral;
	private double confirmedTime;
	private double updateTime;
	private OrderStatus status;
	
	//Constructeurs
	public RepayRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public double getConfirmedTime() {
		return confirmedTime;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getReleasedCollateral() {
		return releasedCollateral;
	}
	
	public double getRepayCollateral() {
		return repayCollateral;
	}
	
	public String getRepayType() {
		return repayType;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public double getUpdateTime() {
		return updateTime;
	}
}
