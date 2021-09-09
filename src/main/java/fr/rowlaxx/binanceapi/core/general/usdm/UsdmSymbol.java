package fr.rowlaxx.binanceapi.core.general.usdm;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.general.future.FutureSymbol;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class UsdmSymbol extends FutureSymbol {
	private static final long serialVersionUID = 2943141519225972622L;

	//Variables
	@JOValue private int settlePlan;
	
	//Constructeurs
	public UsdmSymbol(JSONObject response) {
		super(response);
	}
	
	//Getters
	public int getSettlePlan() {
		return settlePlan;
	}
}