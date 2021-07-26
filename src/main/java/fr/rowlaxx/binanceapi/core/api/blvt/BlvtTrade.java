package fr.rowlaxx.binanceapi.core.api.blvt;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.BinanceResponseJSON;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public abstract class BlvtTrade extends BinanceResponseJSON {
	private static final long serialVersionUID = -5955481296658104911L;
	
	//Variables
	@JsonValue private long id;
	@JsonValue private String tokenName;
	@JsonValue private double amount;
	@JsonValue private long timestamp;
	
	//Constructeurs
	public BlvtTrade(JSONObject response) {
		super(response);
	}
	
	//Getter
	public double getAmount() {
		return amount;
	}
	
	public long getId() {
		return id;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public String getTokenName() {
		return tokenName;
	}
}