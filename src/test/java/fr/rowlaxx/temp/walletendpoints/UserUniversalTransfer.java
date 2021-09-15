package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class UserUniversalTransfer extends JSavONObject {
	private static final long serialVersionUID = -3078644302182133468L;
	
	//Variables
	private long tranId;
	
	//Constructeurs
	public UserUniversalTransfer(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getTranId() {
		return this.tranId;
	}
}