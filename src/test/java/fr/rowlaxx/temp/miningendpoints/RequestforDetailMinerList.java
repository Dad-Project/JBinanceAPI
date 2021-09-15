package fr.rowlaxx.temp.miningendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.requestfordetailminerlist.Data;

import java.util.List;

import org.json.JSONObject;

public class RequestforDetailMinerList extends JSavONObject {
	private static final long serialVersionUID = 5899875898574473520L;
	
	//Variables
	private int code;
	private List<Data> data;
	private String msg;
	
	//Constructeurs
	public RequestforDetailMinerList(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final List<Data> getData() {
		return this.data;
	}
	
	public final String getMsg() {
		return this.msg;
	}
}