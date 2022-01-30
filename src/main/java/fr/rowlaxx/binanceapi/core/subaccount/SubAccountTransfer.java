package fr.rowlaxx.binanceapi.core.subaccount;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class SubAccountTransfer extends JsavonObject {
	private static final long serialVersionUID = 8389870714299884036L;
	
	//Variables
	private String asset;
	private String counterParty;
	private String email;
	private AccountTypes fromAccountType;
	private int qty;
	private String status;
	private long time;
	private AccountTypes toAccountType;
	private long tranId;
	private int type;
	
	//Constructeurs
	public SubAccountTransfer(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final String getCounterParty() {
		return this.counterParty;
	}
	
	public final String getEmail() {
		return this.email;
	}
	
	public final AccountTypes getFromAccountType() {
		return this.fromAccountType;
	}
	
	public final int getQty() {
		return this.qty;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final long getTime() {
		return this.time;
	}
	
	public final AccountTypes getToAccountType() {
		return this.toAccountType;
	}
	
	public final long getTranId() {
		return this.tranId;
	}
	
	public final int getType() {
		return this.type;
	}
}