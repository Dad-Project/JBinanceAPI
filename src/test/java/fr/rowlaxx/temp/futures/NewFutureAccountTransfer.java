package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class NewFutureAccountTransfer extends JSavONObject {
	private static final long serialVersionUID = 8750651901795622673L;
	
	//Variables
	private int tranId;
	
	//Constructeurs
	public NewFutureAccountTransfer(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getTranId() {
		return this.tranId;
	}
}