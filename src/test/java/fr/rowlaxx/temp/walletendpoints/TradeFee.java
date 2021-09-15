package fr.rowlaxx.temp.walletendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class TradeFee extends JSavONObject {
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