package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class AccountStatus extends JSavONObject {
	private static final long serialVersionUID = -2735839940639705355L;
	
	//Variables
	private String data;
	
	//Constructeurs
	public AccountStatus(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getData() {
		return this.data;
	}
}