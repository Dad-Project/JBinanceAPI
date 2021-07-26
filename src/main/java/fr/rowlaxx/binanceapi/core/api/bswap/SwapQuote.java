package fr.rowlaxx.binanceapi.core.api.bswap;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class SwapQuote extends Swap {
	private static final long serialVersionUID = 3361233200282731172L;
	
	//Variables
	@JsonValue private double slippage;
	
	//Constructeurs
	public SwapQuote(JSONObject response) {
		super(response);
	}
	
	//Getters	
	public double getSlippage() {
		return slippage;
	}
}
