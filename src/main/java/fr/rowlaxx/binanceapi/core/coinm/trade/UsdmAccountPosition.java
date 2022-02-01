package fr.rowlaxx.binanceapi.core.coinm.trade;

import fr.rowlaxx.binanceapi.core.futures.trade.FutureAccountPosition;

import org.json.JSONObject;

public class UsdmAccountPosition extends FutureAccountPosition {
	private static final long serialVersionUID = -9115702695146657492L;
	
	//Variables
	private int maxQty;
	
	//Constructeurs
	public UsdmAccountPosition(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getMaxQty() {
		return this.maxQty;
	}
}