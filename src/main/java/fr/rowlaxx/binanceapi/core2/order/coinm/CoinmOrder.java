package fr.rowlaxx.binanceapi.core2.order.coinm;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.futures.trade.FutureOrder;

public class CoinmOrder extends FutureOrder {
	private static final long serialVersionUID = 4274208194826641865L;

	//Variables
	private double cumBase;
	private String pair;
	
	//Constructeurs
	public CoinmOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getCumBase() {
		return cumBase;
	}
	
	public final String getPair() {
		return pair;
	}
}
