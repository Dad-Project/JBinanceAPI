package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class EnableIsolatedMarginAccount extends JSavONObject {
	private static final long serialVersionUID = 7363174779821627082L;
	
	//Variables
	private boolean success;
	private String symbol;
	
	//Constructeurs
	public EnableIsolatedMarginAccount(JSONObject json) {
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