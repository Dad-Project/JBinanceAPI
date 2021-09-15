package fr.rowlaxx.temp.miningendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Cancelhashrateresaleconfiguration extends JSavONObject {
	private static final long serialVersionUID = 1194600761697586137L;
	
	//Variables
	private int code;
	private boolean data;
	private String msg;
	
	//Constructeurs
	public Cancelhashrateresaleconfiguration(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final boolean isData() {
		return this.data;
	}
	
	public final String getMsg() {
		return this.msg;
	}
}