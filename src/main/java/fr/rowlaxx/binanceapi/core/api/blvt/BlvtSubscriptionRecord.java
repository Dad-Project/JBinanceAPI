package fr.rowlaxx.binanceapi.core.api.blvt;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class BlvtSubscriptionRecord extends BlvtRecord {
	private static final long serialVersionUID = -7269202466472450551L;
	
	//Variables
	@JsonValue private double totalcharge;
	
	//Constructeurs
	public BlvtSubscriptionRecord(JSONObject response) {
		super(response);
	}
	
	//Getters
	public double getTotalcharge() {
		return totalcharge;
	}
}
