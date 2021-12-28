package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

abstract class Transfer extends JsavonObject {
	private static final long serialVersionUID = -7499283988217673267L;

	//Variables
	private String address;
	private double amount;
	private String coin;
	private String network;
	private int status;
	private int transferType;
	private String txId;

	//Constructeurs
	public Transfer(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getTransferType() {
		return this.transferType;
	}
	
	public final String getTxId() {
		return this.txId;
	}
	
	public final String getNetwork() {
		return this.network;
	}
	
	public final int getStatus() {
		return this.status;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final String getAddress() {
		return this.address;
	}
	
	public final double getAmount() {
		return this.amount;
	}
}