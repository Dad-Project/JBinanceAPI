package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class QueryMarginAccountsTradeList extends JSavONObject {
	private static final long serialVersionUID = -1427163229894164590L;
	
	//Variables
	private double commission;
	private String commissionAsset;
	private int id;
	private boolean isBestMatch;
	private boolean isBuyer;
	private boolean isIsolated;
	private boolean isMaker;
	private int orderId;
	private double price;
	private double qty;
	private String symbol;
	private long time;
	
	//Constructeurs
	public QueryMarginAccountsTradeList(JSONObject json) {
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
	
	public final boolean isIsolated() {
		return this.isIsolated;
	}
	
	public final boolean isMaker() {
		return this.isMaker;
	}
	
	public final int getOrderId() {
		return this.orderId;
	}
	
	public final double getPrice() {
		return this.price;
	}
	
	public final double getQty() {
		return this.qty;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final long getTime() {
		return this.time;
	}
}