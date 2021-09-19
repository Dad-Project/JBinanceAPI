package fr.rowlaxx.binanceapi.core.bswap;

import org.json.JSONObject;

public class RemoveLiquidityPreview extends AbstractQuote {
	private static final long serialVersionUID = 1286176776271836219L;

	//Variables
	private double quoteAmt;
	private double baseAmt;
	
	//Constructeurs
	public RemoveLiquidityPreview(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getBaseAmt() {
		return baseAmt;
	}
	
	public final double getQuoteAmt() {
		return quoteAmt;
	}
}
