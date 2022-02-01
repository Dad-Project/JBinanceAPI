package fr.rowlaxx.binanceapi.core.futures.trade;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class MarginChangeRecord extends JsavonObject {
	private static final long serialVersionUID = 2272843077467614310L;
	
	//Variables
	private double amount;
	private String asset;
	private PositionSides positionSide;
	private String symbol;
	private long time;
	private int type;
	
	//Constructeurs
	public MarginChangeRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getAsset() {
		return this.asset;
	}
	
	public final PositionSides getPositionSide() {
		return this.positionSide;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final long getTime() {
		return this.time;
	}
	
	public final int getType() {
		return this.type;
	}
}