package fr.rowlaxx.binanceapi.core.futures;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class Repay extends JsavonObject {
	private static final long serialVersionUID = 8493731377993148816L;
	
	//Variables
	private double amount;
	private String coin;
	private String collateralCoin;
	private long repayId;
	
	//Constructeurs
	public Repay(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final String getCollateralCoin() {
		return this.collateralCoin;
	}
	
	public final long getRepayId() {
		return this.repayId;
	}
}