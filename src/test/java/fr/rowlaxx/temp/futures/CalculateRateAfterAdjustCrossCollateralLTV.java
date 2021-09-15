package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CalculateRateAfterAdjustCrossCollateralLTV extends JSavONObject {
	private static final long serialVersionUID = 4678006049508746924L;
	
	//Variables
	private double afterCollateralRate;
	
	//Constructeurs
	public CalculateRateAfterAdjustCrossCollateralLTV(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAfterCollateralRate() {
		return this.afterCollateralRate;
	}
}