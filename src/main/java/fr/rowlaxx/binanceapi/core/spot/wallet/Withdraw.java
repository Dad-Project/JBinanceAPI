package fr.rowlaxx.binanceapi.core.spot.wallet;

import org.json.JSONObject;

public class Withdraw extends Transfer {
	private static final long serialVersionUID = -8135940671960753253L;
	
	//Variables
	private String applyTime;
	private int confirmNo;
	private String id;
	private double transactionFee;
	private String withdrawOrderId;
	
	//Constructeurs
	public Withdraw(JSONObject json) {
		super(TransferType.WITHDRAW, json);
	}
	
	//Getters
	public final String getApplyTime() {
		return this.applyTime;
	}
	
	public final int getConfirmNo() {
		return this.confirmNo;
	}
	
	public final String getId() {
		return this.id;
	}
	
	public final double getTransactionFee() {
		return this.transactionFee;
	}
	
	public final String getWithdrawOrderId() {
		return this.withdrawOrderId;
	}
}