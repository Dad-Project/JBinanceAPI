package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class TransfertoMaster extends JSavONObject {
	private static final long serialVersionUID = 6034278549631320804L;
	
	//Variables
	private long txnId;
	
	//Constructeurs
	public TransfertoMaster(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getTxnId() {
		return this.txnId;
	}
}