package fr.rowlaxx.binanceapi.core.margin;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class MaxBorrow extends JSavONObject {
	private static final long serialVersionUID = -8490747344993137443L;
	
	//Variables
	private double amount;
	private int borrowLimit;
	
	//Constructeurs
	public MaxBorrow(JSONObject json) {
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