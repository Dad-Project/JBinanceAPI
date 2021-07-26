package fr.rowlaxx.binanceapi.core.api.blvt;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.enums.blvt.Status;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public abstract class BlvtTradeResult extends BlvtTrade {
	private static final long serialVersionUID = 86566812977969584L;

	//Variables
	@JsonValue private Status status;
	
	//Constructeurs
	public BlvtTradeResult(JSONObject response) {
		super(response);
	}
	
	//Getter
	public Status getStatus() {
		return status;
	}
}
