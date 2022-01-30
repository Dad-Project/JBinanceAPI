package fr.rowlaxx.binanceapi.core.margin;

import fr.rowlaxx.binanceapi.core.spot.trade.SpotOCOOrderRequest;

public final class MarginOCOOrderRequest extends SpotOCOOrderRequest {

	//Methodes statiques
	public static Builder newMarginBuilder() {
		return new Builder();
	}
	
	//Builder
	@SuppressWarnings("unused")
	public final static class Builder extends SpotOCOOrderRequest.Builder2<Builder> {
		
		//Constructeurs
		public Builder() {
			super(new MarginOCOOrderRequest());
		}
		
		//Methodes réecrites
		@Override
		public MarginOCOOrderRequest build() {
			return (MarginOCOOrderRequest) super.build();
		}
		
		//Setters
		public final Builder isIsolated(Boolean isIsolated) {
			((MarginOCOOrderRequest)request()).isIsolated = isIsolated;
			return this;
		}
		
		public final Builder setSideEffectType(SideEffectType sideEffectType) {
			((MarginOCOOrderRequest)request()).sideEffectType = sideEffectType;
			return this;
		}
	}
	
	//Variables
	private Boolean isIsolated;
	private SideEffectType sideEffectType;
	
	//Constructeurs
	private MarginOCOOrderRequest() {}
	
	//Getters
	public final Boolean getIsIsolated() {
		return isIsolated;
	}
	
	public final SideEffectType getSideEffectType() {
		return sideEffectType;
	}
}
