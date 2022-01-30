package fr.rowlaxx.binanceapi.core.mining;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class AccountEarning extends JsavonObject {
	private static final long serialVersionUID = -8630222808232027375L;

	private String coinName;
	private int type;
	private long time;
	private long puid;
	private String subName;
	private double amount;
	
	public AccountEarning(JSONObject json) {
		super(json);
	}
	
	public final double getAmount() {
		return amount;
	}
	
	public final String getCoinName() {
		return coinName;
	}
	
	public final long getPuid() {
		return puid;
	}
	
	public final String getSubName() {
		return subName;
	}
	
	public final long getTime() {
		return time;
	}
	
	public final int getType() {
		return type;
	}
}
