package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.marginaccounttrade.marginaccountneworder2.Fills;

import java.util.List;

import org.json.JSONObject;

public class MarginAccountNewOrder2 extends JSavONObject {
	private static final long serialVersionUID = -6734481802313153043L;
	
	//Variables
	private String clientOrderId;
	private double cummulativeQuoteQty;
	private double executedQty;
	private List<Fills> fills;
	private boolean isIsolated;
	private int marginBuyBorrowAmount;
	private String marginBuyBorrowAsset;
	private int orderId;
	private double origQty;
	private double price;
	private String side;
	private String status;
	private String symbol;
	private String timeInForce;
	private long transactTime;
	private String type;
	
	//Constructeurs
	public MarginAccountNewOrder2(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getClientOrderId() {
		return this.clientOrderId;
	}
	
	public final double getCummulativeQuoteQty() {
		return this.cummulativeQuoteQty;
	}
	
	public final double getExecutedQty() {
		return this.executedQty;
	}
	
	public final List<Fills> getFills() {
		return this.fills;
	}
	
	public final boolean isIsolated() {
		return this.isIsolated;
	}
	
	public final int getMarginBuyBorrowAmount() {
		return this.marginBuyBorrowAmount;
	}
	
	public final String getMarginBuyBorrowAsset() {
		return this.marginBuyBorrowAsset;
	}
	
	public final int getOrderId() {
		return this.orderId;
	}
	
	public final double getOrigQty() {
		return this.origQty;
	}
	
	public final double getPrice() {
		return this.price;
	}
	
	public final String getSide() {
		return this.side;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final String getTimeInForce() {
		return this.timeInForce;
	}
	
	public final long getTransactTime() {
		return this.transactTime;
	}
	
	public final String getType() {
		return this.type;
	}
}