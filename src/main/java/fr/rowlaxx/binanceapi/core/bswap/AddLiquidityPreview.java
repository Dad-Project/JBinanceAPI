package fr.rowlaxx.binanceapi.core.bswap;

import org.json.JSONObject;

public class AddLiquidityPreview extends RemoveLiquidityPreview {
	private static final long serialVersionUID = 7515721475951777627L;

	//Variables
	private double share;
	
	//Constructeurs
	public AddLiquidityPreview(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getShare() {
		return share;
	}
}
