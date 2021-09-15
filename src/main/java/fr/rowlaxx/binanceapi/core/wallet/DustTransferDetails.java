package fr.rowlaxx.binanceapi.core.wallet;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class DustTransferDetails extends JSavONObject {
	private static final long serialVersionUID = 6031548460637413849L;
	
	//Variables
	private double amount;
	private String fromAsset;
	private long operateTime;
	private double serviceChargeAmount;
	private long transId;
	private double transferedAmount;
	
	//Constructeurs
	public DustTransferDetails(JSONObject json) {
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
	
	public final long getTransId() {
		return this.transId;
	}
	
	public final double getTransferedAmount() {
		return this.transferedAmount;
	}
}