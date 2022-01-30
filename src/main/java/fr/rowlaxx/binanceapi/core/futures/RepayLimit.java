package fr.rowlaxx.binanceapi.core.futures;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class RepayLimit extends JsavonObject {
	private static final long serialVersionUID = -3991816538323425562L;
	
	//Variables
	private String coin;
	private String collateralCoin;
	private int max;
	private int min;
	
	//Constructeurs
	public RepayLimit(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getCoin() {
		return this.coin;
	}
	
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final int getMax() {
		return this.max;
	}
	
	public final int getMin() {
		return this.min;
	}
}