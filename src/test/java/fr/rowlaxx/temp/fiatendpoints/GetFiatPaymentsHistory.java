package fr.rowlaxx.temp.fiatendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.fiatendpoints.getfiatpaymentshistory.Data;

import java.util.List;

import org.json.JSONObject;

public class GetFiatPaymentsHistory extends JSavONObject {
	private static final long serialVersionUID = 7768934647054128297L;
	
	//Variables
	private int code;
	private List<Data> data;
	private String message;
	private boolean success;
	private int total;
	
	//Constructeurs
	public GetFiatPaymentsHistory(JSONObject json) {
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