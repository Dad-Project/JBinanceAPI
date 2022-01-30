package fr.rowlaxx.temp.accountandtradinginterface;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.accountandtradinginterface.queryoptionorder.Data;

import org.json.JSONObject;

public class QueryOptionorder extends JSavONObject {
	private static final long serialVersionUID = -3771845531380476463L;
	
	//Variables
	private int code;
	private OptionTradingPair data;
	private String msg;
	
	//Constructeurs
	public QueryOptionorder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final OptionTradingPair getData() {
		return this.data;
	}
	
	public final String getMsg() {
		return this.msg;
	}
}