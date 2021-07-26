package fr.rowlaxx.binanceapi.core.api.blvt;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public abstract class BlvtRecord extends BlvtTrade {
	private static final long serialVersionUID = -8900244788355003636L;
	
	//Variables
	@JsonValue private double nav;
	@JsonValue private double fee;

	//Constructeurs
	public BlvtRecord(JSONObject response) {
		super(response);
	}
	
	//Getter
	public double getNav() {
		return nav;
	}
	
	public double getFee() {
		return fee;
	}
}
