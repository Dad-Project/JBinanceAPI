package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

public class RepayRecord extends Record {
	private static final long serialVersionUID = -2983885789800198103L;
	
	//Variables
	private double amount;
	private String isolatedSymbol;
	private double principal;
	private double interest;
	
	//Constructeurs
	public RepayRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getIsolatedSymbol() {
		return isolatedSymbol;
	}
	
	public final double getPrincipal() {
		return principal;
	}
	
	public final double getAmount() {
		return this.amount;
	}
	
	public final double getInterest() {
		return this.interest;
	}
}