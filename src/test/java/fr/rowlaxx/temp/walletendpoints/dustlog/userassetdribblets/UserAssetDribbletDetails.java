package fr.rowlaxx.temp.walletendpoints.dustlog.userassetdribblets;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class UserAssetDribbletDetails extends JSavONObject {
	private static final long serialVersionUID = -3396431060073068383L;
	
	//Variables
	private double amount;
	private String fromAsset;
	private long operateTime;
	private double serviceChargeAmount;
	private double transferedAmount;
	private int transId;
	
	//Constructeurs
	public UserAssetDribbletDetails(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getFromAsset() {
		return this.fromAsset;
	}
	
	public final long getOperateTime() {
		return this.operateTime;
	}
	
	public final double getServiceChargeAmount() {
		return this.serviceChargeAmount;
	}
	
	public final double getTransferedAmount() {
		return this.transferedAmount;
	}
	
	public final int getTransId() {
		return this.transId;
	}
}