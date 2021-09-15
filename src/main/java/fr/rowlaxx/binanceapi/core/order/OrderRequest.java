package fr.rowlaxx.binanceapi.core.order;

import java.util.Objects;

public abstract class OrderRequest<T extends OrderTypes>{

	//Variables
	private String symbol;
	private OrderSide side;
	private final T type;
	private TimeInForce timeInForce;
	private Double quantity;
	private Double price;
	private OrderResponseTypes newOrderRespType;
	
	//Constructeurs
	protected OrderRequest(T type) {
		this.type = Objects.requireNonNull(type, "type may not be null.");
	}
	
	//Getters
	public OrderResponseTypes getNewOrderRespType() {
		return newOrderRespType;
	}
	
	public final Double getPrice() {
		return this.price;
	}
	
	public final Double getQuantity() {
		return this.quantity;
	}
	
	public final OrderSide getSide() {
		return this.side;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final TimeInForce getTimeInForce() {
		return this.timeInForce;
	}
	
	public final T getType() {
		return this.type;
	}
	
	//Setters
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	
	public void setSide(OrderSide side) {
		this.side = side;
	}
	
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	public void setTimeInForce(TimeInForce timeInForce) {
		this.timeInForce = timeInForce;
	}
	
	public void setPrice(Double price) {
		this.price = price;
	}
}
