package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class IsolatedAccountLimit extends JsavonObject {
	private static final long serialVersionUID = 2093223017861992923L;
	
	//Variables
	private int enabledAccount;
	private int maxAccount;
	
	//Constructeurs
	public IsolatedAccountLimit(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getEnabledAccount() {
		return this.enabledAccount;
	}
	
	public final int getMaxAccount() {
		return this.maxAccount;
	}
}