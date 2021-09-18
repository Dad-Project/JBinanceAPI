package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

public class RepayRecord extends LoanRecord {
	private static final long serialVersionUID = -2983885789800198103L;
	
	//Variables
	private double amount;
	private double interest;
	
	//Constructeurs
	public RepayRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final double getInterest() {
		return this.interest;
	}
}