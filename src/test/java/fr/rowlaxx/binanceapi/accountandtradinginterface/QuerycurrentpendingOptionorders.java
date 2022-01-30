package fr.rowlaxx.temp.accountandtradinginterface;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.accountandtradinginterface.querycurrentpendingoptionorders.Data;

import java.util.List;

import org.json.JSONObject;

public class QuerycurrentpendingOptionorders extends JSavONObject {
	private static final long serialVersionUID = -5673325280608405927L;
	
	//Variables
	private int code;
	private List<OptionTradingPair> data;
	private String msg;
	
	//Constructeurs
	public QuerycurrentpendingOptionorders(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final List<OptionTradingPair> getData() {
		return this.data;
	}
	
	public final String getMsg() {
		return this.msg;
	}
}