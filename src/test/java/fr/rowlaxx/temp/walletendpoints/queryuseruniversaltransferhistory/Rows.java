package fr.rowlaxx.temp.walletendpoints.queryuseruniversaltransferhistory;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Rows extends JSavONObject {
	private static final long serialVersionUID = 7540880462561445676L;
	
	//Variables
	private int amount;
	private String asset;
	private String status;
	private long timestamp;
	private long tranId;
	private String type;
	
	//Constructeurs
	public Rows(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getAmount() {
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