package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class EnableFuturesforSubaccount extends JSavONObject {
	private static final long serialVersionUID = 9136138694837452897L;
	
	//Variables
	private String email;
	private boolean isFuturesEnabled;
	
	//Constructeurs
	public EnableFuturesforSubaccount(JSONObject json) {
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