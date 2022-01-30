package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class TradeFee extends JsavonObject {
	private static final long serialVersionUID = 6412460026443809680L;
	
	//Variables
	private double makerCommission;
	private String symbol;
	private double takerCommission;
	
	//Constructeurs
	public TradeFee(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getMakerCommission() {
		return this.makerCommission;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final double getTakerCommission() {
		return this.takerCommission;
	}
}