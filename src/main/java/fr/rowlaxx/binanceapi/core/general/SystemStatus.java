package fr.rowlaxx.binanceapi.core.general;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class SystemStatus extends JSavONObject {
	private static final long serialVersionUID = 6247232420296603354L;

	//Variables
	@JOValue private String msg;
	@JOValue private int status;
	
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
