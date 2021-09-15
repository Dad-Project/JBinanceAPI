package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class UniversalTransfer extends JSavONObject {
	private static final long serialVersionUID = -4743716519809928627L;
	
	//Variables
	private long tranId;
	
	//Constructeurs
	public UniversalTransfer(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getTranId() {
		return this.tranId;
	}
}