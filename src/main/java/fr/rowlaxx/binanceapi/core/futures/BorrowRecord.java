package fr.rowlaxx.binanceapi.core.futures;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.BasicOrderStatus;

public class BorrowRecord extends Borrow {
	private static final long serialVersionUID = -4593001988258598284L;

	//Variables
	private double collateralRate;
	private double leftTotal;
	private double leftPrincipal;
	private long deadLine;
	private BasicOrderStatus orderStatus;
	
	//Constructeurs
	public BorrowRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public double getCollateralRate() {
		return collateralRate;
	}
	
	public long getDeadLine() {
		return deadLine;
	}
	
	public double getLeftPrincipal() {
		return leftPrincipal;
	}
	
	public double getLeftTotal() {
		return leftTotal;
	}
	
	public BasicOrderStatus getOrderStatus() {
		return orderStatus;
	}
}