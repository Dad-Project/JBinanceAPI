package fr.rowlaxx.temp.accountandtradinginterface;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.accountandtradinginterface.placemultipleoptionorders.Data;

import java.util.List;

import org.json.JSONObject;

public class PlaceMultipleOptionorders extends JSavONObject {
	private static final long serialVersionUID = 6600168993019938315L;
	
	//Variables
	private int code;
	private List<OptionTradingPair> data;
	private String msg;
	
	//Constructeurs
	public PlaceMultipleOptionorders(JSONObject json) {
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