package fr.rowlaxx.temp.miningendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.requestforminerlist.Data;

import org.json.JSONObject;

public class RequestforMinerList extends JSavONObject {
	private static final long serialVersionUID = 266903090623716866L;
	
	//Variables
	private int code;
	private Data data;
	private String msg;
	
	//Constructeurs
	public RequestforMinerList(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final Data getData() {
		return this.data;
	}
	
	public final String getMsg() {
		return this.msg;
	}
}