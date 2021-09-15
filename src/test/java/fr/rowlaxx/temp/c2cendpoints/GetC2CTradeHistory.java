package fr.rowlaxx.temp.c2cendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.c2cendpoints.getc2ctradehistory.Data;

import java.util.List;

import org.json.JSONObject;

public class GetC2CTradeHistory extends JSavONObject {
	private static final long serialVersionUID = -3240399262777991335L;
	
	//Variables
	private int code;
	private List<Data> data;
	private String message;
	private boolean success;
	private int total;
	
	//Constructeurs
	public GetC2CTradeHistory(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCode() {
		return this.code;
	}
	
	public final List<Data> getData() {
		return this.data;
	}
	
	public final String getMessage() {
		return this.message;
	}
	
	public final boolean isSuccess() {
		return this.success;
	}
	
	public final int getTotal() {
		return this.total;
	}
}