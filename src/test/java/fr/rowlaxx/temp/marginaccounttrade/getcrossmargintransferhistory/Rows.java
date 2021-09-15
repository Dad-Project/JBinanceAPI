package fr.rowlaxx.temp.marginaccounttrade.getcrossmargintransferhistory;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Rows extends JSavONObject {
	private static final long serialVersionUID = 4974505064584104434L;
	
	//Variables
	private double amount;
	private String asset;
	private String status;
	private int timestamp;
	private long txId;
	private String type;
	
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
	
	public final int getTimestamp() {
		return this.timestamp;
	}
	
	public final long getTxId() {
		return this.txId;
	}
	
	public final String getType() {
		return this.type;
	}
}