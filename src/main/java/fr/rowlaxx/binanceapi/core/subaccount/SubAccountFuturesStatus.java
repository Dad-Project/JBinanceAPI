package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class SubAccountFuturesStatus extends JsavonObject {
	private static final long serialVersionUID = 9136138694837452897L;
	
	//Variables
	private String email;
	private boolean isFuturesEnabled;
	
	//Constructeurs
	public SubAccountFuturesStatus(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getEmail() {
		return this.email;
	}
	
	public final boolean isFuturesEnabled() {
		return this.isFuturesEnabled;
	}
}