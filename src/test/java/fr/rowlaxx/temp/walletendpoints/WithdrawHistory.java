package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class WithdrawHistory extends JSavONObject {
	private static final long serialVersionUID = -8135940671960753253L;
	
	//Variables
	private String address;
	private double amount;
	private String applyTime;
	private String coin;
	private int confirmNo;
	private String id;
	private String network;
	private int status;
	private double transactionFee;
	private int transferType;
	private String txId;
	private String withdrawOrderId;
	
	//Constructeurs
	public WithdrawHistory(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAddress() {
		return this.address;
	}
	
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getApplyTime() {
		return this.applyTime;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final int getConfirmNo() {
		return this.confirmNo;
	}
	
	public final String getId() {
		return this.id;
	}
	
	public final String getNetwork() {
		return this.network;
	}
	
	public final int getStatus() {
		return this.status;
	}
	
	public final double getTransactionFee() {
		return this.transactionFee;
	}
	
	public final int getTransferType() {
		return this.transferType;
	}
	
	public final String getTxId() {
		return this.txId;
	}
	
	public final String getWithdrawOrderId() {
		return this.withdrawOrderId;
	}
}