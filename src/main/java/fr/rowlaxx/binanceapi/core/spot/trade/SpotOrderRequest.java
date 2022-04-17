package fr.rowlaxx.binanceapi.core.spot.trade;

import fr.rowlaxx.binanceapi.core.Basic2OrderRequest;

public class SpotOrderRequest extends Basic2OrderRequest<SpotOrderTypes> {

	//Methodes statiques
	public static SpotOrderRequest.Builder newSpotBuilder() {
		return new Builder();
	}
	
	//Builder
	@SuppressWarnings("unchecked")
	protected static class Builder2<B extends Builder2<B>> extends Basic2OrderRequest.Builder<SpotOrderTypes, SpotOrderRequest, B> {

		//Constructeurs
		protected Builder2(SpotOrderRequest request) {
			super(request);
		}
		
		private Builder2() {
			super(new SpotOrderRequest());
		}
		
		//Setters
		public final B setQuoteOrderQty(Double quoteOrderQty) {
			request().quoteOrderQty = quoteOrderQty;
			return (B) this;
		}
		
		public final B setIcebergQty(Double icebergQty) {
			request().icebergQty = icebergQty;
			return (B) this;
		}
		
		public final B setTrailingDelta(Long trailingDelta) {
			request().trailingDelta = trailingDelta;
			return (B) this;
		}	
	}
	
	public final static class Builder extends Builder2<Builder> {}
	
	//Variables
	private Long trailingDelta; 
	private Double quoteOrderQty;
	private Double icebergQty;
	
	//Constructeurs
	protected SpotOrderRequest() {}
	
	//Getters
	public final Double getIcebergQty() {
		return icebergQty;
	}
	
	public final Long getTrailingDelta() {
		return trailingDelta;
	}
	
	public final Double getQuoteOrderQty() {
		return quoteOrderQty;
	}
}