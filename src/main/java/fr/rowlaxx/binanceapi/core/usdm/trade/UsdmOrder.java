package fr.rowlaxx.binanceapi.core.usdm.trade;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.futures.trade.FutureOrder;

public class UsdmOrder extends FutureOrder {
	private static final long serialVersionUID = 8553833220224624389L;

	//Variables
	private double cumQuote;
	
	//Constructeurs
	public UsdmOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public double getCumQuote() {
		return cumQuote;
	}
}
