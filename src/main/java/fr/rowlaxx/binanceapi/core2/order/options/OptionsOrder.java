package fr.rowlaxx.binanceapi.core2.order.options;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.Order;

public class OptionsOrder extends Order<OptionsOrderTypes, OptionsOrderStatus> {
	private static final long serialVersionUID = 1091022057410431662L;

	//Variables
	private double quantity;
	private double fee;
	private double avgPrice;
	private String source;
	private boolean reduceOnly;
	
	//Constructeurs
	public OptionsOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public double getAvgPrice() {
		return avgPrice;
	}
	
	public double getFee() {
		return fee;
	}
	
	public double getQuantity() {
		return quantity;
	}
	
	public String getSource() {
		return source;
	}
	
	public boolean isReduceOnly() {
		return reduceOnly;
	}
}