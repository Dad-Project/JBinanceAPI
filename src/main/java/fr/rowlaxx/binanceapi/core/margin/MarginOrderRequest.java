package fr.rowlaxx.binanceapi.core.margin;

import fr.rowlaxx.binanceapi.core.spot.trade.SpotOrderRequest;

public final class MarginOrderRequest extends SpotOrderRequest {

	//Methodes statiques
	public static MarginOrderRequest.Builder newMarginBuilder() {
		return new Builder();
	}
	
	//Builder
	@SuppressWarnings("unused")
	public final static class Builder extends SpotOrderRequest.Builder2<Builder> {

		//Constructeurs
		private Builder() {
			super(new MarginOrderRequest());
		}
		
		//Methodes
		@Override
		public MarginOrderRequest build() {
			return (MarginOrderRequest) super.build();
		}
		
		//Setters
		public final Builder setIsIsolated(Boolean isIsolated) {
			((MarginOrderRequest)request()).isIsolated = isIsolated;
			return this;
		}
		
		public final Builder setSideEffectType(SideEffectType sideEffectType) {
			((MarginOrderRequest)request()).sideEffectType = sideEffectType;
			return this;
		}
	}
	
	//Constructeurs
	private MarginOrderRequest() {}
	
	//Variables
	private Boolean isIsolated;
	private SideEffectType sideEffectType;
	
	//Getters
	public final Boolean isIsolated() {
		return isIsolated;
	}
	
	public final SideEffectType getSideEffectType() {
		return sideEffectType;
	}
}
