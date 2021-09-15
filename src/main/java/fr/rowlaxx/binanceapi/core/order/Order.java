package fr.rowlaxx.binanceapi.core.order;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class Order<T extends OrderTypes> extends JSavONObject {
	private static final long serialVersionUID = 6457717291749545166L;
	
	//Variables
	@JOValue(mandatory = false) private T type;
	@JOValue(mandatory = false) private Double price;
	private String symbol;
	@JOValue(mandatory = false) private OrderSide side;
	@JOValue(mandatory = false) private TimeInForce timeInForce;
	@JOValue(mandatory = false) private OrderStatus status;
	private String clientOrderId;
	
	//Constructeurs
	public Order(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final T getType() {
		return type;
	}
	
	public final String getClientOrderId() {
		return this.clientOrderId;
	}

	public final Double getPrice() {
		return this.price;
	}
	
	public final OrderSide getSide() {
		return this.side;
	}
	
	public final OrderStatus getStatus() {
		return this.status;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final TimeInForce getTimeInForce() {
		return this.timeInForce;
	}
}