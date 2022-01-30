package fr.rowlaxx.binanceapi.core.options.trade;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.Order;
import fr.rowlaxx.binanceapi.core.Trade;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class OptionOrder extends Order<OptionOrderTypes, OptionOrderStatus> {
	private static final long serialVersionUID = 1091022057410431662L;

	//Variables
	private double quantity;
	private double fee;
	private double avgPrice;
	private String source;
	private boolean reduceOnly;
	@JOValue(mandatory = false) private Trade lastTrade;
	
	//Constructeurs
	public OptionOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAvgPrice() {
		return avgPrice;
	}
	
	public final double getFee() {
		return fee;
	}
	
	public final double getQuantity() {
		return quantity;
	}
	
	public final String getSource() {
		return source;
	}
	
	public final boolean isReduceOnly() {
		return reduceOnly;
	}
	
	public final Trade getLastTrade() {
		return lastTrade;
	}
}