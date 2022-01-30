package fr.rowlaxx.temp.accountandtradinginterface;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.accountandtradinginterface.accountfundingflow.Data;

import java.util.List;

import org.json.JSONObject;

public class Accountfundingflow extends JSavONObject {
	private static final long serialVersionUID = -2956265147469555096L;
	
	//Variables
	private int code;
	private List<OptionTradingPair> data;
	private String msg;
	
	//Constructeurs
	public Accountfundingflow(JSONObject json) {
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