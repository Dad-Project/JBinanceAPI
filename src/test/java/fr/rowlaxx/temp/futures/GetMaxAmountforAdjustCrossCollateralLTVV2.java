package fr.rowlaxx.temp.futures;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class GetMaxAmountforAdjustCrossCollateralLTVV2 extends JSavONObject {
	private static final long serialVersionUID = 1260395813316589932L;
	
	//Variables
	private double maxInAmount;
	private double maxOutAmount;
	
	//Constructeurs
	public GetMaxAmountforAdjustCrossCollateralLTVV2(JSONObject json) {
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