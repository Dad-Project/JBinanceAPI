package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.spot.trade.SpotOrder;

public class MarginOrder extends SpotOrder {
	private static final long serialVersionUID = -7971537535231382670L;

	//Variables
	private boolean isIsolated;
	
	//Constructeurs
	public MarginOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final boolean isIsolated() {
		return isIsolated;
	}
}
