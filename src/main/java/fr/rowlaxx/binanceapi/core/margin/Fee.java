package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class Fee extends JsavonObject {
	private static final long serialVersionUID = -5265660577681727536L;

	private String coin;
	private double dailyInterest;
	private int borrowLimit;
	
	public Fee(JSONObject json) {
		super(json);
	}
	
	public final int getBorrowLimit() {
		return borrowLimit;
	}
	
	public final String getCoin() {
		return coin;
	}
	
	public final double getDailyInterest() {
		return dailyInterest;
	}
}
