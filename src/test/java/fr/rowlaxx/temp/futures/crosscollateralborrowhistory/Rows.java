package fr.rowlaxx.temp.futures.crosscollateralborrowhistory;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Rows extends JSavONObject {
	private static final long serialVersionUID = -4700041180421141L;
	
	//Variables
	private long borrowId;
	private String coin;
	private double collateralAmount;
	private String collateralCoin;
	private double collateralRate;
	private long confirmedTime;
	private long deadline;
	private double leftPrincipal;
	private double leftTotal;
	private String orderStatus;
	
	//Constructeurs
	public Rows(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getBorrowId() {
		return this.borrowId;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final double getCollateralAmount() {
		return this.collateralAmount;
	}
	
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final double getCollateralRate() {
		return this.collateralRate;
	}
	
	public final long getConfirmedTime() {
		return this.confirmedTime;
	}
	
	public final long getDeadline() {
		return this.deadline;
	}
	
	public final double getLeftPrincipal() {
		return this.leftPrincipal;
	}
	
	public final double getLeftTotal() {
		return this.leftTotal;
	}
	
	public final String getOrderStatus() {
		return this.orderStatus;
	}
}