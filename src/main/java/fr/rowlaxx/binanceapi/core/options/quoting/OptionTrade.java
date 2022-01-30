package fr.rowlaxx.binanceapi.core.options.quoting;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.OrderSide;
import fr.rowlaxx.binanceapi.core.Trade;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class OptionTrade extends Trade {
	private static final long serialVersionUID = 1130823384919172576L;
	
	//Variables
	private OrderSide side;
	@JOValue(mandatory = false) private Double quoteQty;
	@JOValue(mandatory = false) private Long tradeId;
	
	//Constructeurs
	public OptionTrade(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Double getQuoteQuantity() {
		return quoteQty;
	}
	
	public final OrderSide getSide() {
		return side;
	}
	
	public final Long getTradeId() {
		return tradeId;
	}
}
