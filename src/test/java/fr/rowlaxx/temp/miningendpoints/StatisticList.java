package fr.rowlaxx.temp.miningendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.statisticlist.Data;

import org.json.JSONObject;

public class StatisticList extends JSavONObject {
	private static final long serialVersionUID = 5321807847387291797L;
	
	//Variables
	private int code;
	private Data data;
	private String msg;
	
	//Constructeurs
	public StatisticList(JSONObject json) {
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