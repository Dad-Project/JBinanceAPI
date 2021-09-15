package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class DepositHistory extends JSavONObject {
	private static final long serialVersionUID = -9056137050856856304L;
	
	//Variables
	private String address;
	private String addressTag;
	private double amount;
	private String coin;
	private String confirmTimes;
	private long insertTime;
	private String network;
	private int status;
	private int transferType;
	private String txId;
	private String unlockConfirm;
	
	//Constructeurs
	public DepositHistory(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAddress() {
		return this.address;
	}
	
	public final String getAddressTag() {
		return this.addressTag;
	}
	
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final String getConfirmTimes() {
		return this.confirmTimes;
	}
	
	public final long getInsertTime() {
		return this.insertTime;
	}
	
	public final String getNetwork() {
		return this.network;
	}
	
	public final int getStatus() {
		return this.status;
	}
	
	public final int getTransferType() {
		return this.transferType;
	}
	
	public final String getTxId() {
		return this.txId;
	}
	
	public final String getUnlockConfirm() {
		return this.unlockConfirm;
	}
}