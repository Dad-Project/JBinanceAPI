package fr.rowlaxx.temp.fiatendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.fiatendpoints.getfiatdepositwithdrawhistory.Data;

import java.util.List;

import org.json.JSONObject;

public class GetFiatDepositWithdrawHistory extends JSavONObject {
	private static final long serialVersionUID = 1292398542403648328L;
	
	//Variables
	private int code;
	private List<Data> data;
	private String message;
	private boolean success;
	private int total;
	
	//Constructeurs
	public GetFiatDepositWithdrawHistory(JSONObject json) {
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