package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class UniversalTransfer extends JsavonObject {
	private static final long serialVersionUID = 7540880462561445676L;
	
	//Variables
	private double amount;
	private String asset;
	private String status;
	private long timestamp;
	private long tranId;
	private String type;
	
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
	
	public final String getStatus() {
		return this.status;
	}
	
	public final long getTimestamp() {
		return this.timestamp;
	}
	
	public final long getTranId() {
		return this.tranId;
	}
	
	public final String getType() {
		return this.type;
	}
}