package fr.rowlaxx.binanceapi.core.margin;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class EnabledIsolatedMarginAccountLimit extends JSavONObject {
	private static final long serialVersionUID = 2093223017861992923L;
	
	//Variables
	private int enabledAccount;
	private int maxAccount;
	
	//Constructeurs
	public EnabledIsolatedMarginAccountLimit(JSONObject json) {
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