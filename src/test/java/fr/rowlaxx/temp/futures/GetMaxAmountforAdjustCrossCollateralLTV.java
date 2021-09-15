package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class GetMaxAmountforAdjustCrossCollateralLTV extends JSavONObject {
	private static final long serialVersionUID = -4481165629594289388L;
	
	//Variables
	private double maxInAmount;
	private double maxOutAmount;
	
	//Constructeurs
	public GetMaxAmountforAdjustCrossCollateralLTV(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getMaxInAmount() {
		return this.maxInAmount;
	}
	
	public final double getMaxOutAmount() {
		return this.maxOutAmount;
	}
}