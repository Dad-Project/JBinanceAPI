package fr.rowlaxx.binanceapi.core.api.usdm;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.future.ContractStatus;
import fr.rowlaxx.binanceapi.core.future.FutureSymbol;
import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class UsdmSymbol extends FutureSymbol {
	private static final long serialVersionUID = 2943141519225972622L;

	//Variables
	@JsonValue private int settlePlan;
	@JsonValue private ContractStatus status;
	
	//Constructeurs
	public UsdmSymbol(JSONObject response) {
		super(response);
	}
	
	//Getters
	public int getSettlePlan() {
		return settlePlan;
	}
	
	public ContractStatus getStatus() {
		return status;
	}
}
