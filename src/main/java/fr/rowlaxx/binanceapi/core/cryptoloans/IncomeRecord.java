package fr.rowlaxx.binanceapi.core.cryptoloans;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class IncomeRecord extends JsavonObject {
	private static final long serialVersionUID = 4653353448979316259L;
	
	private String asset;
	private CryptoLoansTypes type;
	private double amount;
	private long timestamp;
	private long tranId;
	
	public IncomeRecord(JSONObject json) {
		super(json);
	}
	
	public final double getAmount() {
		return amount;
	}
	
	public final String getAsset() {
		return asset;
	}
	
	public final long getTimestamp() {
		return timestamp;
	}
	
	public final long getTranId() {
		return tranId;
	}
	
	public final CryptoLoansTypes getType() {
		return type;
	}
}
