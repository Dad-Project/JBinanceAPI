package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

public class CrossMarginTransferRecord extends MarginTransferRecord {
	private static final long serialVersionUID = 2272958866909036635L;
	
	//Variables
	private String type;
	
	//Constructeurs
	public CrossMarginTransferRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getType() {
		return this.type;
	}
}