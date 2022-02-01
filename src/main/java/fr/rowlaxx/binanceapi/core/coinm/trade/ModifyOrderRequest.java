package fr.rowlaxx.binanceapi.core.coinm.trade;

import java.util.Objects;

import fr.rowlaxx.binanceapi.client.http.BinanceAutoHttpRequest;
import fr.rowlaxx.binanceapi.core.OrderSides;

public class ModifyOrderRequest extends BinanceAutoHttpRequest {

	private Long orderId;
	private String origClientOrderId;
	private String symbol;
	private OrderSides side;
	private Double price;
	private Double quantity;
	
	public ModifyOrderRequest(long orderId) {
		this.orderId = orderId;
	}
	
	public ModifyOrderRequest(String origClientOrderId) {
		Objects.requireNonNull(origClientOrderId, "origCllientOrderId may not be null.");
		this.origClientOrderId = origClientOrderId;
	}
	
	public ModifyOrderRequest setPrice(Double price) {
		this.price = price;
		return this;
	}
	
	public ModifyOrderRequest setQuantity(Double quantity) {
		this.quantity = quantity;
		return this;
	}
	
	public ModifyOrderRequest setSide(OrderSides side) {
		this.side = side;
		return this;
	}
	
	public ModifyOrderRequest setSymbol(String symbol) {
		this.symbol = symbol;
		return this;
	}
	
	public final Long getOrderId() {
		return orderId;
	}
	
	public final String getOrigClientOrderId() {
		return origClientOrderId;
	}
	
	public final Double getPrice() {
		return price;
	}
	
	public final Double getQuantity() {
		return quantity;
	}
	
	public final OrderSides getSide() {
		return side;
	}
	
	public final String getSymbol() {
		return symbol;
	}
}
