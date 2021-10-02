package fr.rowlaxx.temp.accountandtradinginterface.accountfundingflow;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = 6175115117510387034L;
	
	//Variables
	private double amount;
	private long createDate;
	private String currency;
	private long id;
	private String type;
	
	//Constructeurs
	public Data(JSONObject json) {
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