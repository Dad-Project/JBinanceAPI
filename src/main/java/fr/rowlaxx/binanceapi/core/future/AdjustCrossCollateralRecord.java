package fr.rowlaxx.binanceapi.core.future;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class AdjustCrossCollateralRecord extends JSavONObject {
	private static final long serialVersionUID = -7808659684934114456L;
	
	//Variables
	private double afterCollateralRate;
	private String coin;
	private double preCollateralRate;
	private String status;
	
	//Constructeurs
	public AdjustCrossCollateralRecord(JSONObject json) {
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