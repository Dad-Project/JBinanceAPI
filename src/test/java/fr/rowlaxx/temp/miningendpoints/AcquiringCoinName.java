package fr.rowlaxx.temp.miningendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.miningendpoints.acquiringcoinname.Data;

import java.util.List;

import org.json.JSONObject;

public class AcquiringCoinName extends JSavONObject {
	private static final long serialVersionUID = 1641907169857619766L;
	
	//Variables
	private int code;
	private List<Data> data;
	private String msg;
	
	//Constructeurs
	public AcquiringCoinName(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final List<Data> getData() {
		return this.data;
	}
	
	public final String getMsg() {
		return this.msg;
	}
}