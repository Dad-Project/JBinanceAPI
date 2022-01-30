package fr.rowlaxx.binanceapi.core.options.trade;

import fr.rowlaxx.binanceapi.core.options.quoting.OptionTrade;

import org.json.JSONObject;

public class OptionUserTrade extends OptionTrade {
	private static final long serialVersionUID = -1855470021194568087L;
	
	//Variables
	private double fee;
	private String liquidity;
	private long orderId;
	private String quoteAsset;
	private double realizedProfit;
	private String symbol;
	private String type;
	private String volatility;
	
	//Constructeurs
	public OptionUserTrade(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getFee() {
		return this.fee;
	}

	public final String getLiquidity() {
		return this.liquidity;
	}
	
	public final long getOrderId() {
		return this.orderId;
	}
	
	public final String getQuoteAsset() {
		return this.quoteAsset;
	}
	
	public final double getRealizedProfit() {
		return this.realizedProfit;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}

	public final String getType() {
		return this.type;
	}
	
	public final String getVolatility() {
		return this.volatility;
	}
}