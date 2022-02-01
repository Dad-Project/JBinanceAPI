package fr.rowlaxx.binanceapi.core.usdm.trade;

import fr.rowlaxx.binanceapi.core.futures.trade.FutureAccountAsset;

import org.json.JSONObject;

public class UsdmAccountAsset extends FutureAccountAsset {
	private static final long serialVersionUID = 4683143051533540722L;
	
	//Variables
	private boolean marginAvailable;
	private long updateTime;
	
	//Constructeurs
	public UsdmAccountAsset(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final boolean isMarginAvailable() {
		return this.marginAvailable;
	}

	public final long getUpdateTime() {
		return this.updateTime;
	}
}