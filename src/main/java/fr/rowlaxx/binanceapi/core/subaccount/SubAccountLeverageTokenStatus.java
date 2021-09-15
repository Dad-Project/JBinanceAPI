package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SubAccountLeverageTokenStatus extends JSavONObject {
	private static final long serialVersionUID = 7646592083560556522L;
	
	//Variables
	private String email;
	private boolean enableBlvt;
	
	//Constructeurs
	public SubAccountLeverageTokenStatus(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getEmail() {
		return this.email;
	}
	
	public final boolean isEnableBlvt() {
		return this.enableBlvt;
	}
}