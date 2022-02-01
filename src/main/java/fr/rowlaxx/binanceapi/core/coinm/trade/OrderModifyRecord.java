package fr.rowlaxx.binanceapi.core.coinm.trade;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

import org.json.JSONObject;

public class OrderModifyRecord extends JsavonObject {
	private static final long serialVersionUID = 804164809007716532L;
	
	//Variables	
	@JOValue(path = "amendment") private int count;
	@JOValue(path = "amendment/price", key = "before") private double priceBefore;
	@JOValue(path = "amendment/price", key = "after") private double priceAfter;
	@JOValue(path = "amendment/origQty", key = "before") private double quantityBefore;
	@JOValue(path = "amendment/origQty", key = "after") private double quantityAfter;
	
	private long amendmentId;
	private String clientOrderId;
	private long orderId;
	private String pair;
	private String symbol;
	private long time;
	
	//Constructeurs
	public OrderModifyRecord(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getCount() {
		return count;
	}
	
	public final double getPriceAfter() {
		return priceAfter;
	}
	
	public final double getPriceBefore() {
		return priceBefore;
	}
	
	public final double getQuantityAfter() {
		return quantityAfter;
	}
	
	public final double getQuantityBefore() {
		return quantityBefore;
	}
	
	public final long getAmendmentId() {
		return this.amendmentId;
	}
	
	public final String getClientOrderId() {
		return this.clientOrderId;
	}
	
	public final long getOrderId() {
		return this.orderId;
	}
	
	public final String getPair() {
		return this.pair;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final long getTime() {
		return this.time;
	}
}