package fr.rowlaxx.binanceapi.core.usdm.marketdata;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.futures.marketdata.FutureSymbol;

public class UsdmSymbol extends FutureSymbol {
	private static final long serialVersionUID = 2943141519225972622L;

	//Variables
	private int settlePlan;
	
	//Constructeurs
	public UsdmSymbol(JSONObject response) {
		super(response);
	}
	
	//Getters
	public int getSettlePlan() {
		return settlePlan;
	}
}
