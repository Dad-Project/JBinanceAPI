package fr.rowlaxx.binanceapi.core.wallet.future;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class Position extends JsavonObject {
	private static final long serialVersionUID = -2121018695205256757L;
	
	//Variables
	private double entryPrice;
	@JOValue(mandatory = false)
	private Double markPrice;
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