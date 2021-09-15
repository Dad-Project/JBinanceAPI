package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SubAccountMarginStatus extends JSavONObject {
	private static final long serialVersionUID = -6846527915209205383L;
	
	//Variables
	private String email;
	private boolean isMarginEnabled;
	
	//Constructeurs
	public SubAccountMarginStatus(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getEmail() {
		return this.email;
	}
	
	public final boolean isMarginEnabled() {
		return this.isMarginEnabled;
	}
}