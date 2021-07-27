package fr.rowlaxx.binanceapi.core.api.bswap;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.utils.json.JsonValue;

public class SwapRecord extends Swap {
	private static final long serialVersionUID = 1947665096156059489L;

	//Variables
	@JsonValue private long swapId;
	@JsonValue private long swapTime;
	@JsonValue private LiquidityOperationStatus status;
	
	//Constructeurs
	public SwapRecord(JSONObject response) {
		super(response);
	}

	//Getters
	public long getSwapId() {
		return swapId;
	}
	
	public long getSwapTime() {
		return swapTime;
	}
	
	public LiquidityOperationStatus getStatus() {
		return status;
	}
}
