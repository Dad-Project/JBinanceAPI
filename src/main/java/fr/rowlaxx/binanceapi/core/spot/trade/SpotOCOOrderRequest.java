package fr.rowlaxx.binanceapi.core.spot.trade;

import java.util.Objects;

import fr.rowlaxx.binanceapi.core.OrderRequest;
import fr.rowlaxx.binanceapi.core.TimeInForce;

public class SpotOCOOrderRequest extends OrderRequest {
	
	//Methodes statiques
	public static Builder newSpotBuilder() {
		return new Builder();
	}
	
	//Builder
	@SuppressWarnings("unchecked")
	protected static class Builder2<B extends Builder2<B>> extends OrderRequest.Builder<SpotOCOOrderRequest, B> {

		//Constructeurs
		private Builder2() {
			super(new SpotOCOOrderRequest());
		}
		
		protected Builder2(SpotOCOOrderRequest request) {
			super(request);
		}
		
		//Methodes
		@Override
		protected void checkBuild() {
			super.checkBuild();
			Objects.requireNonNull(request().stopPrice, "stopPrice may not be null.");
			Objects.requireNonNull(request().getQuantity(), "quantity may not be null.");
			Objects.requireNonNull(request().getPrice(), "price may not be null.");
		}
		
		//Setters
		public final B setStopPrice(Double stopPrice) {
			request().stopPrice = stopPrice;
			return (B) this;
		}

		public final B setListClientOrderId(String listClientOrderId) {
			request().listClientOrderId = listClientOrderId;
			return (B) this;
		}

		public final B setLimitClientOrderId(String limitClientOrderId) {
			request().limitClientOrderId = limitClientOrderId;
			return (B) this;
		}

		public final B setLimitIcebergQty(Double limitIcebergQty) {
			request().limitIcebergQty = limitIcebergQty;
			return (B) this;
		}

		public final B setStopClientOrderId(String stopClientOrderId) {
			request().stopClientOrderId = stopClientOrderId;
			return (B) this;
		}

		public final B setStopLimitPrice(Double stopLimitPrice) {
			request().stopLimitPrice = stopLimitPrice;
			return (B) this;
		}

		public final B setStopIcebergQty(Double stopIcebergQty) {
			request().stopIcebergQty = stopIcebergQty;
			return (B) this;
		}

		public final B setStopLimitTimeInForce(TimeInForce stopLimitTimeInForce) {
			request().stopLimitTimeInForce = stopLimitTimeInForce;
			return (B) this;
		}
		
		public final B setTrailingDelta(Long trailingDelta) {
			request().trailingDelta = trailingDelta;
			return (B) this;
		}
	}
	
	public static final class Builder extends Builder2<Builder> {}
	
	//Constructeurs
	protected SpotOCOOrderRequest() {}
	
	//Variables
	private Long trailingDelta;
	private Double stopPrice;
	private String listClientOrderId;
	private String limitClientOrderId;
	private Double limitIcebergQty;
	private String stopClientOrderId;
	private Double stopLimitPrice;
	private Double stopIcebergQty;
	private TimeInForce stopLimitTimeInForce;
	
	//Getters
	public final String getLimitClientOrderId() {
		return limitClientOrderId;
	}
	
	public final Long getTrailingDelta() {
		return trailingDelta;
	}
	
	public final Double getLimitIcebergQty() {
		return limitIcebergQty;
	}
	
	public final String getListClientOrderId() {
		return listClientOrderId;
	}
	
	public final String getStopClientOrderId() {
		return stopClientOrderId;
	}
	
	public final Double getStopIcebergQty() {
		return stopIcebergQty;
	}
	
	public final Double getStopLimitPrice() {
		return stopLimitPrice;
	}
	
	public final TimeInForce getStopLimitTimeInForce() {
		return stopLimitTimeInForce;
	}
	
	public final Double getStopPrice() {
		return stopPrice;
	}
}