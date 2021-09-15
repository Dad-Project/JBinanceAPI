package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class EnableLeverageTokenforSubaccount extends JSavONObject {
	private static final long serialVersionUID = 7646592083560556522L;
	
	//Variables
	private String email;
	private boolean enableBlvt;
	
	//Constructeurs
	public EnableLeverageTokenforSubaccount(JSONObject json) {
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