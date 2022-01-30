package fr.rowlaxx.binanceapi.core.spot.wallet;

import java.util.Objects;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.ManualValue;

public abstract class Transfer extends JsavonObject {
	private static final long serialVersionUID = -7499283988217673267L;

	//Variables
	private String address;
	private double amount;
	private String coin;
	private String network;
	private int status;
	private int transferType;
	private String txId;
	@ManualValue private TransferType type;

	//Constructeurs
	public Transfer(TransferType type, JSONObject json) {
		super(json);
		this.type = Objects.requireNonNull(type);
	}
	
	//Getters
	public final int getTransferType() {
		return this.transferType;
	}
	
	public final TransferType getType() {
		return type;
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