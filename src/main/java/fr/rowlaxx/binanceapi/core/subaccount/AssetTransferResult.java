package fr.rowlaxx.binanceapi.core.subaccount;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class AssetTransferResult extends JsavonObject {
	private static final long serialVersionUID = -6087111270730674571L;
	
	//Variables
	private boolean success;
	private long txnId;
	
	//Constructeurs
	public AssetTransferResult(JSONObject json) {
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