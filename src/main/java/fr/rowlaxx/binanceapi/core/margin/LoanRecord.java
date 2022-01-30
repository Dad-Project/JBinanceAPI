package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

public class LoanRecord extends Record {
	private static final long serialVersionUID = 5995803459195148862L;
	
	private String isolatedSymbol;
	private double principal;
	
	//Constructeurs
	public LoanRecord(JSONObject json) {
		super(json);
	}
	
	public final String getIsolatedSymbol() {
		return this.isolatedSymbol;
	}
	
	public final double getPrincipal() {
		return this.principal;
	}
}