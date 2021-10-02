package fr.rowlaxx.temp.accountandtradinginterface;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.accountandtradinginterface.cancelmultipleoptionorders.Data;

import java.util.List;

import org.json.JSONObject;

public class CancelMultipleOptionorders extends JSavONObject {
	private static final long serialVersionUID = -4566539076348097381L;
	
	//Variables
	private int code;
	private List<OptionTradingPairInfo> data;
	private String msg;
	
	//Constructeurs
	public CancelMultipleOptionorders(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final List<OptionTradingPairInfo> getData() {
		return this.data;
	}
	
	public final String getMsg() {
		return this.msg;
	}
}