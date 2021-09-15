package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SystemStatus extends JSavONObject {
	private static final long serialVersionUID = -5682604012554433425L;
	
	//Variables
	private String msg;
	private int status;
	
	//Constructeurs
	public SystemStatus(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getMsg() {
		return this.msg;
	}
	
	public final int getStatus() {
		return this.status;
	}
}