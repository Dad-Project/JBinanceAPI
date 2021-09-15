package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SubAccountStatus extends JSavONObject {
	private static final long serialVersionUID = -3348239805616535046L;
	
	//Variables
	private String email;
	private long insertTime;
	private boolean isFutureEnabled;
	private boolean isMarginEnabled;
	private boolean isSubUserEnabled;
	private boolean isUserActive;
	private long mobile;
	
	//Constructeurs
	public SubAccountStatus(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getEmail() {
		return this.email;
	}
	
	public final long getInsertTime() {
		return this.insertTime;
	}
	
	public final boolean isFutureEnabled() {
		return this.isFutureEnabled;
	}
	
	public final boolean isMarginEnabled() {
		return this.isMarginEnabled;
	}
	
	public final boolean isSubUserEnabled() {
		return this.isSubUserEnabled;
	}
	
	public final boolean isUserActive() {
		return this.isUserActive;
	}
	
	public final long getMobile() {
		return this.mobile;
	}
}