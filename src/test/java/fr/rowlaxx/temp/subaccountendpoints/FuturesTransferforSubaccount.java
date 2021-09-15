package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class FuturesTransferforSubaccount extends JSavONObject {
	private static final long serialVersionUID = 2353539688524108997L;
	
	//Variables
	private long txnId;
	
	//Constructeurs
	public FuturesTransferforSubaccount(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getTxnId() {
		return this.txnId;
	}
}