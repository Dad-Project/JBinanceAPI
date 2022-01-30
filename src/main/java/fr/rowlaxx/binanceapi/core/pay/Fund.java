package fr.rowlaxx.binanceapi.core.pay;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class Fund extends JsavonObject {
	private static final long serialVersionUID = 3647982529595321857L;

	private double amount;
	private String currency;
	
	public Fund(JSONObject json) {
		super(json);
	}
	
	public final double getAmount() {
		return amount;
	}
	
	public final String getCurrency() {
		return currency;
	}
	
}
