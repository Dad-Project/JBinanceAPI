package fr.rowlaxx.binanceapi.core.subaccount.transfer;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class UniversalTransfer extends JSavONObject {
	private static final long serialVersionUID = 6390388275296769062L;
	
	//Variables
	private double amount;
	private String asset;
	private long createTimeStamp;
	private String fromAccountType;
	private String fromEmail;
	private String status;
	private String toAccountType;
	private String toEmail;
	private long tranId;
	
	//Constructeurs
	public UniversalTransfer(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getAsset() {
		return this.asset;
	}
	
	public final long getCreateTimeStamp() {
		return this.createTimeStamp;
	}
	
	public final String getFromAccountType() {
		return this.fromAccountType;
	}
	
	public final String getFromEmail() {
		return this.fromEmail;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final String getToAccountType() {
		return this.toAccountType;
	}
	
	public final String getToEmail() {
		return this.toEmail;
	}
	
	public final long getTranId() {
		return this.tranId;
	}
}