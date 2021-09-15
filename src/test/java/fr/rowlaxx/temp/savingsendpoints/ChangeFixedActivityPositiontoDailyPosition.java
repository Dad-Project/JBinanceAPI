package fr.rowlaxx.temp.savingsendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class ChangeFixedActivityPositiontoDailyPosition extends JSavONObject {
	private static final long serialVersionUID = 4389323164929333090L;
	
	//Variables
	private int dailyPurchaseId;
	private boolean success;
	private long time;
	
	//Constructeurs
	public ChangeFixedActivityPositiontoDailyPosition(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getDailyPurchaseId() {
		return this.dailyPurchaseId;
	}
	
	public final boolean isSuccess() {
		return this.success;
	}
	
	public final long getTime() {
		return this.time;
	}
}