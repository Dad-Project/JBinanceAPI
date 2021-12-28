package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public abstract class MarginTransferRecord extends JsavonObject {
	private static final long serialVersionUID = 4974505064584104434L;
	
	//Variables
	private double amount;
	private String asset;
	private String status;
	private int timestamp;
	private long txId;

	//Constructeurs
	public MarginTransferRecord(JSONObject json) {
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
}