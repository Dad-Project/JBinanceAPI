package fr.rowlaxx.binanceapi.core.futuresalgo;

import fr.rowlaxx.binanceapi.client.http.BinanceAutoHttpRequest;
import fr.rowlaxx.binanceapi.core.OrderSides;
import fr.rowlaxx.binanceapi.core.futures.trade.PositionSides;

public class VPOrderRequest extends BinanceAutoHttpRequest {

	//Methodes statiques
	public static Builder newBuilder() {
		return new Builder();
	}
	
	//Builder
	public static class Builder{
		
		//Variables
		private VPOrderRequest request = new VPOrderRequest();
		
		//Methodes
		public VPOrderRequest build() {			
			try {
				return request;
			}finally {
				request = null;
			}
		}
		
		//Setters
		public Builder setClientAlgoId(String clientAlgoId) {
			request.clientAlgoId = clientAlgoId;
			return this;
		}
		
		public Builder setLimitPrice(double limitPrice) {
			request.limitPrice = limitPrice;
			return this;
		}
		
		public Builder setPositionSide(PositionSides positionSide) {
			request.positionSide = positionSide;
			return this;
		}
		
		public Builder setQuantity(double quantity) {
			request.quantity = quantity;
			return this;
		}
		
		public Builder setReduceOnly(boolean reduceOnly) {
			request.reduceOnly = reduceOnly;
			return this;
		}
		
		public Builder setSide(OrderSides side) {
			request.side = side;
			return this;
		}
		
		public Builder setSymbol(String symbol) {
			request.symbol = symbol;
			return this;
		}
		
		public Builder setUrgency(Urgency urgency) {
			request.urgency = urgency;
			return this;
		}
	}
	
	//Variables
	private String symbol;
	private OrderSides side;
	private PositionSides positionSide;
	private double quantity;
	private Urgency urgency;
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
	
	public Urgency getUrgency() {
		return urgency;
	}
	
	public boolean isReduceOnly() {
		return reduceOnly;
	}
}
