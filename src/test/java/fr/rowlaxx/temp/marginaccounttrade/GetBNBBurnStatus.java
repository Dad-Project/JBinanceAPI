package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class GetBNBBurnStatus extends JSavONObject {
	private static final long serialVersionUID = -3363236296432911500L;
	
	//Variables
	private boolean interestBNBBurn;
	private boolean spotBNBBurn;
	
	//Constructeurs
	public GetBNBBurnStatus(JSONObject json) {
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