package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SubaccountFuturesAssetTransfer extends JSavONObject {
	private static final long serialVersionUID = -6087111270730674571L;
	
	//Variables
	private boolean success;
	private long txnId;
	
	//Constructeurs
	public SubaccountFuturesAssetTransfer(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final boolean isSuccess() {
		return this.success;
	}
	
	public final long getTxnId() {
		return this.txnId;
	}
}