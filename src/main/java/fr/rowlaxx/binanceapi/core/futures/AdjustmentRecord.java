package fr.rowlaxx.binanceapi.core.futures;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class AdjustmentRecord extends JsavonObject {
	private static final long serialVersionUID = -7808659684934114456L;
	
	//Variables
	private double afterCollateralRate;
	private String coin;
	private double preCollateralRate;
	private String status;
	
	//Constructeurs
	public AdjustmentRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAfterCollateralRate() {
		return this.afterCollateralRate;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final double getPreCollateralRate() {
		return this.preCollateralRate;
	}
	
	public final String getStatus() {
		return this.status;
	}
}