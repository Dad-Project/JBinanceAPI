package fr.rowlaxx.binanceapi.core.order;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.annotations.object.JOValue;

public abstract class Order<T extends OrderTypes, S extends OrderStatus> extends SimpleOrder {
	private static final long serialVersionUID = 6457717291749545166L;
	
	@JOValue(key = {"transactTime", "createDate", "updateTime"})
	private long transactTime;
	
	@JOValue(mandatory = false)
	private Double price;
	@JOValue(mandatory = false)
	private OrderSide side;
	@JOValue(mandatory = false)
	private Double executedQty;
	@JOValue(mandatory = false)
	private S status;
	@JOValue(mandatory = false)
	private T type;
	@JOValue(mandatory = false)
	private TimeInForce timeInForce;
	
	//Constructeurs
	public Order(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getTransactTime() {
		return this.transactTime;
	}
	
	public final Double getExecutedQty() {
		return executedQty;
	}
	
	public final Double getPrice() {
		return price;
	}
	
	public final OrderSide getSide() {
		return side;
	}
	
	public final S getStatus() {
		return status;
	}
	
	public final TimeInForce getTimeInForce() {
		return timeInForce;
	}
	
	public final T getType() {
		return type;
	}
}