package fr.rowlaxx.temp.accountandtradinginterface;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Fundstransfer extends JSavONObject {
	private static final long serialVersionUID = -3367953788066163704L;
	
	//Variables
	private int code;
	private int data;
	private String msg;
	
	//Constructeurs
	public Fundstransfer(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final int getData() {
		return this.data;
	}
	
	public final String getMsg() {
		return this.msg;
	}
}