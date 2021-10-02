package fr.rowlaxx.temp.accountandtradinginterface;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CancelallOptionorders extends JSavONObject {
	private static final long serialVersionUID = 481897437796258609L;
	
	//Variables
	private int code;
	private String msg;
	
	//Constructeurs
	public CancelallOptionorders(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final String getMsg() {
		return this.msg;
	}
}