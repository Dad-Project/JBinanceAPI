package fr.rowlaxx.temp.miningendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.hashrateresaledetail.Data;

import org.json.JSONObject;

public class HashrateResaleDetail extends JSavONObject {
	private static final long serialVersionUID = 6257532387180077610L;
	
	//Variables
	private int code;
	private Data data;
	private String msg;
	
	//Constructeurs
	public HashrateResaleDetail(JSONObject json) {
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