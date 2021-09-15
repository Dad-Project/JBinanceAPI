package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class QueryMaxBorrow extends JSavONObject {
	private static final long serialVersionUID = -8490747344993137443L;
	
	//Variables
	private double amount;
	private int borrowLimit;
	
	//Constructeurs
	public QueryMaxBorrow(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final int getBorrowLimit() {
		return this.borrowLimit;
	}
}