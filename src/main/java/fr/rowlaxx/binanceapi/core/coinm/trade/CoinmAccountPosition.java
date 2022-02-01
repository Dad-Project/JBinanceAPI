package fr.rowlaxx.binanceapi.core.coinm.trade;

import fr.rowlaxx.binanceapi.core.futures.trade.FutureAccountPosition;

import org.json.JSONObject;

public class CoinmAccountPosition extends FutureAccountPosition {
	private static final long serialVersionUID = -6715634890222642316L;
	
	//Variables
	private double askNotional;
	private double bidNotional;
	private double maxNotional;	
	
	//Constructeurs
	public CoinmAccountPosition(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAskNotional() {
		return this.askNotional;
	}
	
	public final double getBidNotional() {
		return this.bidNotional;
	}
	
	public final double getMaxNotional() {
		return this.maxNotional;
	}
	
}