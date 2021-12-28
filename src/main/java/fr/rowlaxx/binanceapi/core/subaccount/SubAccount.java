package fr.rowlaxx.binanceapi.core.subaccount;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class SubAccount extends JsavonObject {
	private static final long serialVersionUID = 7666190389359963590L;
	
	//Variables
	private long createTime;
	private String email;
	private boolean isFreeze;
	
	//Constructeurs
	public SubAccount(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getCreateTime() {
		return this.createTime;
	}
	
	public final String getEmail() {
		return this.email;
	}
	
	public final boolean isFreeze() {
		return this.isFreeze;
	}
}