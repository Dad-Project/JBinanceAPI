package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

public class IsolatedMarginTransferRecord extends MarginTransferRecord {
	private static final long serialVersionUID = 4779714752784142470L;

	//Variables
	private String transFrom;
	private String transTo;
	
	//Constructeurs
	public IsolatedMarginTransferRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getTransFrom() {
		return transFrom;
	}
	
	public final String getTransTo() {
		return transTo;
	}
}
