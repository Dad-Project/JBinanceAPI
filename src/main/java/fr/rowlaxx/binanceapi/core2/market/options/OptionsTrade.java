package fr.rowlaxx.binanceapi.core2.market.options;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.Trade;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class OptionsTrade extends Trade {
	private static final long serialVersionUID = 1130823384919172576L;
	
	//Variables
	private int side;
	private double quoteQty;
	@JOValue(mandatory = false)
	private Long tradeId;
	
	//Constructeurs
	public OptionsTrade(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getQuoteQty() {
		return quoteQty;
	}
	
	public final int getSide() {
		return side;
	}
	
	public final Long getTradeId() {
		return tradeId;
	}
}
