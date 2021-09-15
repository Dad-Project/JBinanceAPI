package fr.rowlaxx.temp.subaccountendpoints.querysubaccountlist;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SubAccounts extends JSavONObject {
	private static final long serialVersionUID = 7666190389359963590L;
	
	//Variables
	private long createTime;
	private String email;
	private boolean isFreeze;
	
	//Constructeurs
	public SubAccounts(JSONObject json) {
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