package fr.rowlaxx.binanceapi.core.savings;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class PositionAmount extends JsavonObject {
	private static final long serialVersionUID = -5545989450045049012L;
	
	//Variables
	private double amount;
	private double amountInBTC;
	private double amountInUSDT;
	private String asset;
	
	//Constructeurs
	public PositionAmount(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final double getAmountInBTC() {
		return this.amountInBTC;
	}
	
	public final double getAmountInUSDT() {
		return this.amountInUSDT;
	}
	
	public final String getAsset() {
		return this.asset;
	}
}