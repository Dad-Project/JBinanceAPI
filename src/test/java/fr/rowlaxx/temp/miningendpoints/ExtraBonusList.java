package fr.rowlaxx.temp.miningendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.extrabonuslist.Data;

import org.json.JSONObject;

public class ExtraBonusList extends JSavONObject {
	private static final long serialVersionUID = 8687940755928114373L;
	
	//Variables
	private int code;
	private Data data;
	private String msg;
	
	//Constructeurs
	public ExtraBonusList(JSONObject json) {
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