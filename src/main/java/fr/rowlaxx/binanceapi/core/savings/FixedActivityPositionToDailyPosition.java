package fr.rowlaxx.binanceapi.core.savings;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class FixedActivityPositionToDailyPosition extends JsavonObject {
	private static final long serialVersionUID = 4389323164929333090L;
	
	//Variables
	private int dailyPurchaseId;
	private boolean success;
	private long time;
	
	//Constructeurs
	public FixedActivityPositionToDailyPosition(JSONObject json) {
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