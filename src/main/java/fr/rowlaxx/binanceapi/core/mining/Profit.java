package fr.rowlaxx.binanceapi.core.mining;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;

public class Profit extends JSavONObject {
	private static final long serialVersionUID = -6612554663600466638L;
	
	//Variables
	private String coinName;
	private double profitAmount;
	private int status;
	private long time;
	private int type;

	//Constructeurs
	public Profit(JSONObject json) {
		super(json);
	}

	//Getters
	public final String getCoinName() {
		return this.coinName;
	}

	public final double getProfitAmount() {
		return this.profitAmount;
	}

	public final int getStatus() {
		return this.status;
	}

	public final long getTime() {
		return this.time;
	}

	public final int getType() {
		return this.type;
	}
}