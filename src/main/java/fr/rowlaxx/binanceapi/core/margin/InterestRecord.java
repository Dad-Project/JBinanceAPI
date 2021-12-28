package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class InterestRecord extends JsavonObject {
	private static final long serialVersionUID = 559063585587719408L;
	
	//Variables
	private String asset;
	private double interest;
	private long interestAccuredTime;
	private double interestRate;
	private String isolatedSymbol;
	private double principal;
	private String type;
	
	//Constructeurs
	public InterestRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getInterest() {
		return this.interest;
	}
	
	public final long getInterestAccuredTime() {
		return this.interestAccuredTime;
	}
	
	public final double getInterestRate() {
		return this.interestRate;
	}
	
	public final String getIsolatedSymbol() {
		return this.isolatedSymbol;
	}
	
	public final double getPrincipal() {
		return this.principal;
	}
	
	public final String getType() {
		return this.type;
	}
}