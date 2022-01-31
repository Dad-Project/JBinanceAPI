package fr.rowlaxx.binanceapi.core;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.annotations.JOValue;

public class CompressedTrade extends SideableTrade {
	private static final long serialVersionUID = 8527421398690357381L;

	//Variables
	@JOValue(key = "f")
	private long firstTradeId;
	@JOValue(key = "l")
	private long lastTradeId;
	
	//Constructeurs
	public CompressedTrade(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getFirstTradeId() {
		return firstTradeId;
	}
	
	public final long getLastTradeId() {
		return lastTradeId;
	}
}
