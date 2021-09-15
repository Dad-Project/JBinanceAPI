package fr.rowlaxx.temp.futures.getfutureaccounttransactionhistorylist;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Rows extends JSavONObject {
	private static final long serialVersionUID = -6935224934507104236L;
	
	//Variables
	private double amount;
	private String asset;
	private String status;
	private long timestamp;
	private int tranId;
	private int type;
	
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
	
	public final int getTranId() {
		return this.tranId;
	}
	
	public final int getType() {
		return this.type;
	}
}