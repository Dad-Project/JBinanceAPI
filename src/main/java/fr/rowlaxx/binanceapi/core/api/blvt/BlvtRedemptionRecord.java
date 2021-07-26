package fr.rowlaxx.binanceapi.core.api.blvt;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class BlvtRedemptionRecord extends BlvtRecord {
	private static final long serialVersionUID = 8889795237143076258L;

	//Variables
	private @JsonValue double netProceed;
	
	//Constructeurs
	public BlvtRedemptionRecord(JSONObject response) {
		super(response);
	}

	//Getter
	public double getNetProceed() {
		return netProceed;
	}
}
