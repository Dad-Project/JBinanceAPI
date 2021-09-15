package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class TransfertoSubaccountofSameMaster extends JSavONObject {
	private static final long serialVersionUID = 1104687540147901037L;
	
	//Variables
	private long txnId;
	
	//Constructeurs
	public TransfertoSubaccountofSameMaster(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getTxnId() {
		return this.txnId;
	}
}