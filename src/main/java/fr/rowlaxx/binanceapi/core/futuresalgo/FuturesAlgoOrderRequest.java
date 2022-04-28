package fr.rowlaxx.binanceapi.core.futuresalgo;

import java.util.Objects;

import fr.rowlaxx.binanceapi.client.http.BinanceAutoHttpRequest;
import fr.rowlaxx.binanceapi.core.OrderSides;
import fr.rowlaxx.binanceapi.core.futures.trade.PositionSides;

public class FuturesAlgoOrderRequest extends BinanceAutoHttpRequest {

	//Builder
	@SuppressWarnings("unchecked")
	protected static class BaseBuilder<T, E extends FuturesAlgoOrderRequest> {
		
		//Variables
		private FuturesAlgoOrderRequest request;
		
		//Constructeurs
		protected BaseBuilder(final E request) {
			this.request = Objects.requireNonNull(request, "request may not be null.");
		}
		
		//Methodes
		public E build() {			
			try {
				return (E) request;
			}finally {
				request = null;
			}
		}
		
		protected E request() {
			return (E) request;
		}
		
		//Setters
		public T setClientAlgoId(String clientAlgoId) {
			request.clientAlgoId = clientAlgoId;
			return (T) this;
		}
		
		public T setLimitPrice(double limitPrice) {
			request.limitPrice = limitPrice;
			return (T) this;
		}
		
		public T setPositionSide(PositionSides positionSide) {
			request.positionSide = positionSide;
			return (T) this;
		}
		
		public T setQuantity(double quantity) {
			request.quantity = quantity;
			return (T) this;
		}
		
		public T setReduceOnly(boolean reduceOnly) {
			request.reduceOnly = reduceOnly;
			return (T) this;
		}
		
		public T setSide(OrderSides side) {
			request.side = side;
			return (T) this;
		}
		
		public T setSymbol(String symbol) {
			request.symbol = symbol;
			return (T) this;
		}
	}
	
	//Variables
	private String symbol;
	private OrderSides side;
	private PositionSides positionSide;
	private double quantity;
	private String clientAlgoId;
	private boolean reduceOnly;
	private double limitPrice;
	
	//Getters
	public String getClientAlgoId() {
		return clientAlgoId;
	}
	
	public double getLimitPrice() {
		return limitPrice;
	}
	
	public PositionSides getPositionSide() {
		return positionSide;
	}
	
	public double getQuantity() {
		return quantity;
	}
	
	public OrderSides getSide() {
		return side;
	}
	
	public String getSymbol() {
		return symbol;
	}

	public boolean isReduceOnly() {
		return reduceOnly;
	}
}
