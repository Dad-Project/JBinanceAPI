package fr.rowlaxx.temp.miningendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class HashrateResaleRequest extends JSavONObject {
	private static final long serialVersionUID = 3771196523202437942L;
	
	//Variables
	private int code;
	private int data;
	private String msg;
	
	//Constructeurs
	public HashrateResaleRequest(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final int getData() {
		return this.data;
	}
	
	public final String getMsg() {
		return this.msg;
	}
}