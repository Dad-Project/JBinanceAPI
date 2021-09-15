package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class DisableIsolatedMarginAccount extends JSavONObject {
	private static final long serialVersionUID = -906602565425321461L;
	
	//Variables
	private boolean success;
	private String symbol;
	
	//Constructeurs
	public DisableIsolatedMarginAccount(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final boolean isSuccess() {
		return this.success;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}