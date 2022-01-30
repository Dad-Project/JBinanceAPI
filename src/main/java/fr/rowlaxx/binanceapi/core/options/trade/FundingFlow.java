package fr.rowlaxx.binanceapi.core.options.trade;

import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public class FundingFlow extends JsavonObject {
	private static final long serialVersionUID = -6334321097254077700L;
	
	//Variables
	private double amount;
	private long createDate;
	private String currency;
	private long id;
	private String type;
	
	//Constructeurs
	public FundingFlow(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final long getCreateDate() {
		return this.createDate;
	}
	
	public final String getCurrency() {
		return this.currency;
	}
	
	public final long getId() {
		return this.id;
	}
	
	public final String getType() {
		return this.type;
	}
}