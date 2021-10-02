package fr.rowlaxx.temp.accountandtradinginterface;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.accountandtradinginterface.optiontradelist.Data;

import java.util.List;

import org.json.JSONObject;

public class OptionTradeList extends JSavONObject {
	private static final long serialVersionUID = -1162221737309038709L;
	
	//Variables
	private int code;
	private List<OptionTradingPairInfo> data;
	private String msg;
	
	//Constructeurs
	public OptionTradeList(JSONObject json) {
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