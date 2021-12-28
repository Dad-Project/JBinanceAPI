package fr.rowlaxx.binanceapi.core.general;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class SystemStatus extends JsavonObject {
	private static final long serialVersionUID = 6247232420296603354L;

	//Variables
	private String msg;
	private int status;
	
	//Constructeurs
	public SystemStatus(JSONObject json) {
		super(json);
	}
	
	//Getters
	public String getMsg() {
		return msg;
	}
	
	public int getStatus() {
		return status;
	}
}
