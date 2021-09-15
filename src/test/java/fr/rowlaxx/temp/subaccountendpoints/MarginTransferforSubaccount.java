package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class MarginTransferforSubaccount extends JSavONObject {
	private static final long serialVersionUID = 2912340610865971514L;
	
	//Variables
	private long txnId;
	
	//Constructeurs
	public MarginTransferforSubaccount(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getTxnId() {
		return this.txnId;
	}
}