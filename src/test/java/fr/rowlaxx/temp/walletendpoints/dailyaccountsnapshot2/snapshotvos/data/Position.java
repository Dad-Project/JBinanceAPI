package fr.rowlaxx.temp.walletendpoints.dailyaccountsnapshot2.snapshotvos.data;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Position extends JSavONObject {
	private static final long serialVersionUID = -2121018695205256757L;
	
	//Variables
	private double entryPrice;
	private double markPrice;
	private double positionAmt;
	private String symbol;
	private double unRealizedProfit;
	
	//Constructeurs
	public Position(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getEntryPrice() {
		return this.entryPrice;
	}
	
	public final double getMarkPrice() {
		return this.markPrice;
	}
	
	public final double getPositionAmt() {
		return this.positionAmt;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final double getUnRealizedProfit() {
		return this.unRealizedProfit;
	}
}