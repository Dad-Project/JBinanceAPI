package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class BNBBurnStatus extends JsavonObject {
	private static final long serialVersionUID = -3363236296432911500L;
	
	//Variables
	private boolean interestBNBBurn;
	private boolean spotBNBBurn;
	
	//Constructeurs
	public BNBBurnStatus(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final boolean isInterestBNBBurn() {
		return this.interestBNBBurn;
	}
	
	public final boolean isSpotBNBBurn() {
		return this.spotBNBBurn;
	}
}