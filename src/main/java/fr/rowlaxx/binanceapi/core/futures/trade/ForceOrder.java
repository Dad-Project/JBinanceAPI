package fr.rowlaxx.binanceapi.core.futures.trade;

import fr.rowlaxx.binanceapi.core.OrderStatus;
import fr.rowlaxx.binanceapi.core.TimeInForce;
import fr.rowlaxx.binanceapi.core.OrderSides;
import fr.rowlaxx.jsavon.JsavonObject;

import org.json.JSONObject;

public abstract class ForceOrder extends JsavonObject {
	private static final long serialVersionUID = 6928611056390809931L;
	
	//Variables
	private double avgPrice;
	private String clientOrderId;
	private boolean closePosition;
	private double executedQty;
	private long orderId;
	private double origQty;
	private FutureOrderTypes origType;
	private PositionSides positionSide;
	private double price;
	private boolean reduceOnly;
	private OrderSides side;
	private OrderStatus status;
	private double stopPrice;
	private String symbol;
	private long time;
	private TimeInForce timeInForce;
	private FutureOrderTypes type;
	private long updateTime;
	private WorkingType workingType;
	
	//Constructeurs
	public ForceOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAvgPrice() {
		return avgPrice;
	}
	
	public final String getClientOrderId() {
		return clientOrderId;
	}
	
	public final double getExecutedQty() {
		return executedQty;
	}
	
	public final long getOrderId() {
		return orderId;
	}
	
	public final double getOrigQty() {
		return origQty;
	}
	
	public final FutureOrderTypes getOrigType() {
		return origType;
	}
	
	public final PositionSides getPositionSide() {
		return positionSide;
	}
	
	public final double getPrice() {
		return price;
	}
	
	public final OrderSides getSide() {
		return side;
	}
	
	public final OrderStatus getStatus() {
		return status;
	}
	
	public final double getStopPrice() {
		return stopPrice;
	}
	
	public final String getSymbol() {
		return symbol;
	}
	
	public final long getTime() {
		return time;
	}
	
	public final TimeInForce getTimeInForce() {
		return timeInForce;
	}
	
	public final FutureOrderTypes getType() {
		return type;
	}
	
	public final long getUpdateTime() {
		return updateTime;
	}
	
	public final WorkingType getWorkingType() {
		return workingType;
	}
	
	public final boolean isClosePosition() {
		return closePosition;
	}
	
	public final boolean isReduceOnly() {
		return reduceOnly;
	}
}