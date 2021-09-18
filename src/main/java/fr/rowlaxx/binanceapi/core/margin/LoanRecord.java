package fr.rowlaxx.binanceapi.core.margin;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class LoanRecord extends JSavONObject {
	private static final long serialVersionUID = 5995803459195148862L;
	
	//Variables
	private String asset;
	private String isolatedSymbol;
	private double principal;
	private String status;
	private long timestamp;
	private long txId;
	
	//Constructeurs
	public LoanRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final String getIsolatedSymbol() {
		return this.isolatedSymbol;
	}
	
	public final double getPrincipal() {
		return this.principal;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final long getTimestamp() {
		return this.timestamp;
	}
	
	public final long getTxId() {
		return this.txId;
	}
}