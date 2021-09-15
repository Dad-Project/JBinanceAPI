package fr.rowlaxx.temp.miningendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.hashrateresalelist.Data;

import org.json.JSONObject;

public class HashrateResaleList extends JSavONObject {
	private static final long serialVersionUID = -5336057589749575041L;
	
	//Variables
	private int code;
	private Data data;
	private String msg;
	
	//Constructeurs
	public HashrateResaleList(JSONObject json) {
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