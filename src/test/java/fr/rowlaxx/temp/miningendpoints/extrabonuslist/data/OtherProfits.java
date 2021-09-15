package fr.rowlaxx.temp.miningendpoints.extrabonuslist.data;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class OtherProfits extends JSavONObject {
	private static final long serialVersionUID = 4204145096482868363L;
	
	//Variables
	private String coinName;
	private double profitAmount;
	private int status;
	private long time;
	private int type;
	
	//Constructeurs
	public OtherProfits(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getCoinName() {
		return this.coinName;
	}
	
	public final double getProfitAmount() {
		return this.profitAmount;
	}
	
	public final int getStatus() {
		return this.status;
	}
	
	public final long getTime() {
		return this.time;
	}
	
	public final int getType() {
		return this.type;
	}
}