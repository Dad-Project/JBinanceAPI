package fr.rowlaxx.temp.walletendpoints.dusttransfer;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class TransferResult extends JSavONObject {
	private static final long serialVersionUID = 6031548460637413849L;
	
	//Variables
	private double amount;
	private String fromAsset;
	private long operateTime;
	private double serviceChargeAmount;
	private long tranId;
	private double transferedAmount;
	
	//Constructeurs
	public TransferResult(JSONObject json) {
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
	
	public final long getTranId() {
		return this.tranId;
	}
	
	public final double getTransferedAmount() {
		return this.transferedAmount;
	}
}