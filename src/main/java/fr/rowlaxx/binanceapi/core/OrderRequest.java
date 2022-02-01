package fr.rowlaxx.binanceapi.core;

import java.util.Objects;

import fr.rowlaxx.binanceapi.client.http.BinanceAutoHttpRequest;

public abstract class OrderRequest extends BinanceAutoHttpRequest {
	
	//Builder
	@SuppressWarnings("unchecked")
	protected abstract static class Builder<T extends OrderRequest, B extends Builder<T, B>> {
		
		//Variables
		private OrderRequest request;
		
		//Constructeurs
		protected Builder(T request) {
			this.request = Objects.requireNonNull(request);
		}
		
		//Getters
		protected final T request() {
			return (T) request;
		}
		
		//Setters
		public final B setSymbol(String symbol) {
			request.symbol = symbol;
			return (B) this;
		}

		public final B setSide(OrderSides side) {
			request.side = side;
			return (B) this;
		}

		public final B setQuantity(Double quantity) {
			request.quantity = quantity;
			return (B) this;
		}

		public final B setPrice(Double price) {
			request.price = price;
			return (B) this;
		}

		public final B setNewOrderRespType(OrderResponseTypes newOrderRespType) {
			request.newOrderRespType = newOrderRespType;
			return (B) this;
		}
		
		public T build() {
			checkBuild();
			try {
				return (T) this.request;
			}finally {
				this.request = null;
			}
		}
		
		protected void checkBuild() {
			Objects.requireNonNull(request.symbol, "symbol may not be null.");
			Objects.requireNonNull(request.side, "side may not be null.");
		}
	}
	
	//Constructeurs
	protected OrderRequest() {}
	
	//Variables
	private String symbol;
	private OrderSides side;
	private Double quantity;
	private Double price;
	private OrderResponseTypes newOrderRespType;
	
	//Getters
	public final OrderResponseTypes getNewOrderRespType() {
		return newOrderRespType;
	}
	
	public final Double getPrice() {
		return this.price;
	}
	
	public final Double getQuantity() {
		return this.quantity;
	}
	
	public final OrderSides getSide() {
		return this.side;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
}
