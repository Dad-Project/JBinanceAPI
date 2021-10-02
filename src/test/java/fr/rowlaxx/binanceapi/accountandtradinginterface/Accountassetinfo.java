package fr.rowlaxx.temp.accountandtradinginterface;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.accountandtradinginterface.accountassetinfo.Data;

import java.util.List;

import org.json.JSONObject;

public class Accountassetinfo extends JSavONObject {
	private static final long serialVersionUID = -1030527078316993697L;
	
	//Variables
	private int code;
	private List<OptionTradingPairInfo> data;
	private String msg;
	
	//Constructeurs
	public Accountassetinfo(JSONObject json) {
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