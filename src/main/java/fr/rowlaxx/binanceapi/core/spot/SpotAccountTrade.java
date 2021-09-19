package fr.rowlaxx.binanceapi.core.spot;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SpotAccountTrade extends JSavONObject {
	private static final long serialVersionUID = -5483341101213361605L;
	
	//Variables
	private double commission;
	private String commissionAsset;
	private int id;
	private boolean isBestMatch;
	private boolean isBuyer;
	private boolean isMaker;
	private int orderId;
	private int orderListId;
	private double price;
	private double qty;
	private double quoteQty;
	private String symbol;
	private long time;
	
	//Constructeurs
	public SpotAccountTrade(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getCommission() {
		return this.commission;
	}
	
	public final String getCommissionAsset() {
		return this.commissionAsset;
	}
	
	public final int getId() {
		return this.id;
	}
	
	public final boolean isBestMatch() {
		return this.isBestMatch;
	}
	
	public final boolean isBuyer() {
		return this.isBuyer;
	}
	
	public final boolean isMaker() {
		return this.isMaker;
	}
	
	public final int getOrderId() {
		return this.orderId;
	}
	
	public final int getOrderListId() {
		return this.orderListId;
	}
	
	public final double getPrice() {
		return this.price;
	}
	
	public final double getQty() {
		return this.qty;
	}
	
	public final double getQuoteQty() {
		return this.quoteQty;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final long getTime() {
		return this.time;
	}
}