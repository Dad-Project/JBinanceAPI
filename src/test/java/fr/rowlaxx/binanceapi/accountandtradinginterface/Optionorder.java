package fr.rowlaxx.temp.accountandtradinginterface;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.accountandtradinginterface.optionorder.Data;

import org.json.JSONObject;

public class Optionorder extends JSavONObject {
	private static final long serialVersionUID = 4103515026280080100L;
	
	//Variables
	private int code;
	private OptionTradingPairInfo data;
	private String msg;
	
	//Constructeurs
	public Optionorder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final OptionTradingPairInfo getData() {
		return this.data;
	}
	
	public final String getMsg() {
		return this.msg;
	}
}