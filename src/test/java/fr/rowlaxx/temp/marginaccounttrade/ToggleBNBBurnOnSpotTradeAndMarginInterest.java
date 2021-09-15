package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class ToggleBNBBurnOnSpotTradeAndMarginInterest extends JSavONObject {
	private static final long serialVersionUID = 5416148636303763279L;
	
	//Variables
	private boolean interestBNBBurn;
	private boolean spotBNBBurn;
	
	//Constructeurs
	public ToggleBNBBurnOnSpotTradeAndMarginInterest(JSONObject json) {
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