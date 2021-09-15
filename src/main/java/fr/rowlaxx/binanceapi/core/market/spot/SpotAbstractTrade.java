package fr.rowlaxx.binanceapi.core.market.spot;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.market.Trade;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

abstract class SpotAbstractTrade extends Trade {
	private static final long serialVersionUID = -4799770263609131397L;
	
	//Variables
	@JOValue(key = { "isBuyerMaker", "m" })
	private boolean isBuyerMaker;

	//Constructeurs
	public SpotAbstractTrade(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final boolean isBuyerMaker() {
		return isBuyerMaker;
	}

}