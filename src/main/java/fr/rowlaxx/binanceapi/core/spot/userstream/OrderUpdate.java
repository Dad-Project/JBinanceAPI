package fr.rowlaxx.binanceapi.core.spot.userstream;

import fr.rowlaxx.binanceapi.core.OrderSides;
import fr.rowlaxx.binanceapi.core.OrderStatus;
import fr.rowlaxx.binanceapi.core.TimeInForce;
import fr.rowlaxx.binanceapi.core.spot.trade.SpotOrderTypes;
import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class OrderUpdate extends JsavonObject {
	private static final long serialVersionUID = -5811862000449084814L;

	//Variables
	@JOValue(key = "s") private String symbol;
	@JOValue(key = "c") private String clientOrderID;
	@JOValue(key = "S") private OrderSides side;
	@JOValue(key = "o") private SpotOrderTypes orderType;
	@JOValue(key = "f") private TimeInForce timeInForce;
	@JOValue(key = "q") private double orderQuantity;
	@JOValue(key = "p") private double orderPrice;
	@JOValue(key = "P") private double stopPrice;
	@JOValue(key = "d") private double trailingDelta;
	@JOValue(key = "F") private double icebergQuantity;
	@JOValue(key = "g") private long orderListId;
	@JOValue(key = "C") private String originalClientOrderId;
	@JOValue(key = "x") private ExecutionTypes executionType;
	@JOValue(key = "X") private OrderStatus orderStatus;
	@JOValue(key = "r") private String orderRejectReason;
	@JOValue(key = "i") private long orderId;
	@JOValue(key = "l") private long lastExecutedQuantity;
	@JOValue(key = "z") private double cumulativeFilledQuantity;
	@JOValue(key = "L") private double lastExecutedPrice;
	@JOValue(key = "n") private double comissionAmount;
	@JOValue(key = "N") private String comissionAsset;
	@JOValue(key = "T") private long transactionTime;
	@JOValue(key = "t") private long tradeId;
	@JOValue(key = "I") private String ignore1;
	@JOValue(key = "w") private boolean orderOnTheBook;
	@JOValue(key = "m") private boolean tradeMakerSide;
	@JOValue(key = "M") private boolean ignore2;
	@JOValue(key = "O") private long orderCreationTime;
	@JOValue(key = "Z") private double cumulativeQuoteAssetTransactedQuantity;
	@JOValue(key = "Y") private double lastQuoteAssetTransactedQuantity;
	@JOValue(key = "Q") private double quoteOrderQty;

	//Getters
	public String getClientOrderID() {
		return clientOrderID;
	}
	
	public double getComissionAmount() {
		return comissionAmount;
	}
	
	public String getComissionAsset() {
		return comissionAsset;
	}
	
	public double getCumulativeFilledQuantity() {
		return cumulativeFilledQuantity;
	}
	
	public double getCumulativeQuoteAssetTransactedQuantity() {
		return cumulativeQuoteAssetTransactedQuantity;
	}
	
	public ExecutionTypes getExecutionType() {
		return executionType;
	}
	
	public double getIcebergQuantity() {
		return icebergQuantity;
	}
	
	public String getIgnore1() {
		return ignore1;
	}
	
	public double getLastExecutedPrice() {
		return lastExecutedPrice;
	}
	
	public long getLastExecutedQuantity() {
		return lastExecutedQuantity;
	}
	
	public double getLastQuoteAssetTransactedQuantity() {
		return lastQuoteAssetTransactedQuantity;
	}
	
	public long getOrderCreationTime() {
		return orderCreationTime;
	}
	
	public long getOrderId() {
		return orderId;
	}
	
	public long getOrderListId() {
		return orderListId;
	}
	
	public double getOrderPrice() {
		return orderPrice;
	}
	
	public double getOrderQuantity() {
		return orderQuantity;
	}
	
	public String getOrderRejectReason() {
		return orderRejectReason;
	}
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	
	public SpotOrderTypes getOrderType() {
		return orderType;
	}
	
	public String getOriginalClientOrderId() {
		return originalClientOrderId;
	}
	
	public double getQuoteOrderQty() {
		return quoteOrderQty;
	}
	
	public OrderSides getSide() {
		return side;
	}
	
	public double getStopPrice() {
		return stopPrice;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public TimeInForce getTimeInForce() {
		return timeInForce;
	}
	
	public long getTradeId() {
		return tradeId;
	}
	
	public double getTrailingDelta() {
		return trailingDelta;
	}
	
	public long getTransactionTime() {
		return transactionTime;
	}
	
	public boolean isOrderOnTheBook() {
		return orderOnTheBook;
	}
	
	public boolean isTradeMakerSide() {
		return tradeMakerSide;
	}
	
	public boolean getIgnore2() {
		return ignore2;
	}
}
