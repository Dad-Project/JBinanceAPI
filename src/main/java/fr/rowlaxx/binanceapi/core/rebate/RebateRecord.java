package fr.rowlaxx.binanceapi.core.rebate;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class RebateRecord extends JsavonObject {
	private static final long serialVersionUID = -2933323015918824078L;

	private String asset;
	private int type;
	private double amount;
	private long updateTime;
	
	public RebateRecord(JSONObject json) {
		super(json);
	}
	
	public final double getAmount() {
		return amount;
	}
	
	public final String getAsset() {
		return asset;
	}
	
	public final int getType() {
		return type;
	}
	
	public final long getUpdateTime() {
		return updateTime;
	}
}
