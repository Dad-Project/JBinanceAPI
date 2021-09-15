package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CalculateRateAfterAdjustCrossCollateralLTVV2 extends JSavONObject {
	private static final long serialVersionUID = -369669705403561863L;
	
	//Variables
	private double afterCollateralRate;
	
	//Constructeurs
	public CalculateRateAfterAdjustCrossCollateralLTVV2(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAfterCollateralRate() {
		return this.afterCollateralRate;
	}
}