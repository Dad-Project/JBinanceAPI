package fr.rowlaxx.temp.accountandtradinginterface;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.accountandtradinginterface.canceloptionorder.Data;

import org.json.JSONObject;

public class CancelOptionorder extends JSavONObject {
	private static final long serialVersionUID = 141952608213399947L;
	
	//Variables
	private int code;
	private OptionTradingPair data;
	private String msg;
	
	//Constructeurs
	public CancelOptionorder(JSONObject json) {
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