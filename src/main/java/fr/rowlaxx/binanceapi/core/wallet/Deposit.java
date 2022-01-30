package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

public class Deposit extends Transfer {
	private static final long serialVersionUID = -9056137050856856304L;
	
	//Variables
	private String addressTag;
	private String confirmTimes;
	private long insertTime;
	private String unlockConfirm;
	
	//Constructeurs
	public Deposit(JSONObject json) {
		super(TransferType.DEPOSIT, json);
	}
	
	//Getters
	public final String getAddressTag() {
		return this.addressTag;
	}

	public final String getConfirmTimes() {
		return this.confirmTimes;
	}
	
	public final long getInsertTime() {
		return this.insertTime;
	}
	
	public final String getUnlockConfirm() {
		return this.unlockConfirm;
	}
}