package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class AdjustCrossCollateralLTV extends JSavONObject {
	private static final long serialVersionUID = 2063440224360972855L;
	
	//Variables
	private double amount;
	private String collateralCoin;
	private String direction;
	private long time;
	
	//Constructeurs
	public AdjustCrossCollateralLTV(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final String getDirection() {
		return this.direction;
	}
	
	public final long getTime() {
		return this.time;
	}
}