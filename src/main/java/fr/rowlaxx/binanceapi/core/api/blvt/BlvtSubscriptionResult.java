package fr.rowlaxx.binanceapi.core.api.blvt;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class BlvtSubscriptionResult extends BlvtTrade {
	private static final long serialVersionUID = 8532407646442025110L;

	//Variables
	@JsonValue private double cost;
	
	//Constructeurs
	public BlvtSubscriptionResult(JSONObject response) {
		super(response);
	}
	
	//Getter
	public double getCost() {
		return cost;
	}
}
