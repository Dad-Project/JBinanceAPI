package fr.rowlaxx.temp.marginaccounttrade.getisolatedmargintransferhistory;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Rows extends JSavONObject {
	private static final long serialVersionUID = 7186506023598027480L;
	
	//Variables
	private double amount;
	private String asset;
	private String status;
	private long timestamp;
	private String transFrom;
	private String transTo;
	private long txId;
	
	//Constructeurs
	public Rows(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getAsset() {
		return this.asset;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final long getTimestamp() {
		return this.timestamp;
	}
	
	public final String getTransFrom() {
		return this.transFrom;
	}
	
	public final String getTransTo() {
		return this.transTo;
	}
	
	public final long getTxId() {
		return this.txId;
	}
}