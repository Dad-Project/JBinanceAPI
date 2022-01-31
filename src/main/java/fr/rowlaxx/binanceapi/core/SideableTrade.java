package fr.rowlaxx.binanceapi.core;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.annotations.JOValue;

public class SideableTrade extends Trade {
	private static final long serialVersionUID = -4799770263609131397L;
	
	//Variables
	@JOValue(key = { "isBuyerMaker", "m" })
	private boolean isBuyerMaker;

	//Constructeurs
	public SideableTrade(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final boolean isBuyerMaker() {
		return isBuyerMaker;
	}

}