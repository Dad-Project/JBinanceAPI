package fr.rowlaxx.binanceapi.core.options.quoting;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.Trade;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class OptionTrade extends Trade {
	private static final long serialVersionUID = 1130823384919172576L;
	
	//Variables
	private int side;
	private double quoteQty;
	@JOValue(mandatory = false)
	private Long tradeId;
	
	//Constructeurs
	public OptionTrade(JSONObject json) {
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
