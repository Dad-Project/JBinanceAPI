package fr.rowlaxx.binanceapi.core.order.spot;

import org.json.JSONObject;

public class SpotOrder extends BasicSpotOrder {
	private static final long serialVersionUID = 6515467018603198407L;
	
	//Variables
	private long orderListId;
	
	//Constructeurs
	public SpotOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getOrderListId() {
		return orderListId;
	}
}