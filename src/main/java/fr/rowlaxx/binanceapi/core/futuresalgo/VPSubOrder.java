package fr.rowlaxx.binanceapi.core.futuresalgo;

import fr.rowlaxx.binanceapi.core.OrderSides;
import fr.rowlaxx.binanceapi.core.OrderStatus;
import fr.rowlaxx.binanceapi.core.TimeInForce;

public class VPSubOrder {

	//Variables
	private long algoId;
	private long orderId;
	private OrderStatus orderStatus;
	private double executedQty;
	private double executedAmt;
	private double feeAmt;
	private double feeAsset;
	private long bookTime;
	private double avgPrice;
	private OrderSides side;
	private String symbol;
	private int subId;
	private TimeInForce timeInForce;
	private double origQty;
	
	//Getters
	public long getAlgoId() {
		return algoId;
	}
	
	public double getAvgPrice() {
		return avgPrice;
	}
	
	public long getBookTime() {
		return bookTime;
	}
	
	public double getExecutedAmt() {
		return executedAmt;
	}
	
	public double getExecutedQty() {
		return executedQty;
	}
	
	public double getFeeAmt() {
		return feeAmt;
	}
	
	public double getFeeAsset() {
		return feeAsset;
	}
	
	public long getOrderId() {
		return orderId;
	}
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	
	public double getOrigQty() {
		return origQty;
	}
	
	public OrderSides getSide() {
		return side;
	}
	
	public TimeInForce getTimeInForce() {
		return timeInForce;
	}
	
	public int getSubId() {
		return subId;
	}
	
	public String getSymbol() {
		return symbol;
	}
}