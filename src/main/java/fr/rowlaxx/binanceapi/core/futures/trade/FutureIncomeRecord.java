package fr.rowlaxx.binanceapi.core.futures.trade;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class FutureIncomeRecord extends JsavonObject {
	private static final long serialVersionUID = -3641048468984265150L;
	
	//Variables
	private String asset;
	private double income;
	private IncomeTypes incomeType;
	private String info;
	private String symbol;
	private long time;
	private String tradeId;
	private long tranId;
	
	//Constructeurs
	public FutureIncomeRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getIncome() {
		return this.income;
	}
	
	public final IncomeTypes getIncomeType() {
		return this.incomeType;
	}
	
	public final String getInfo() {
		return this.info;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final long getTime() {
		return this.time;
	}
	
	public final String getTradeId() {
		return this.tradeId;
	}
	
	public final long getTranId() {
		return this.tranId;
	}
}