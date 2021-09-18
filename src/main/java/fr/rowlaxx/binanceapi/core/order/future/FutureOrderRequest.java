package fr.rowlaxx.binanceapi.core.order.future;

import fr.rowlaxx.binanceapi.core.order.Basic2OrderRequest;

public final class FutureOrderRequest extends Basic2OrderRequest<FutureOrderTypes> {

	//Methodes statiques
	public static Builder newBuilder() {
		return new Builder();
	}
	
	//Builder
	@SuppressWarnings("unused")
	public final static class Builder extends Basic2OrderRequest.Builder<FutureOrderTypes, FutureOrderRequest, Builder> {

		//Constructeurs
		private Builder() {
			super(new FutureOrderRequest());
		}
		
		//Setters
		public final Builder setActivationPrice(Double activationPrice) {
			request().activationPrice = activationPrice;
			return this;
		}
		
		public final Builder setCallbackRate(Double callbackRate) {
			request().callbackRate = callbackRate;
			return this;
		}
		
		public final Builder setClosePosition(Boolean closePosition) {
			request().closePosition = closePosition;
			return this;
		}
		
		public final Builder setPositionSide(PositionSides positionSide) {
			request().positionSide = positionSide;
			return this;
		}
		
		public final Builder setPriceProtect(Boolean priceProtect) {
			request().priceProtect = priceProtect;
			return this;
		}
		
		public final Builder setReduceOnly(Boolean reduceOnly) {
			request().reduceOnly = reduceOnly;
			return this;
		}
		
		public final Builder setWorkingType(WorkingType workingType) {
			request().workingType = workingType;
			return this;
		}
	}
	
	//Variables
	private PositionSides positionSide;
	private Boolean reduceOnly;
	private Boolean closePosition;
	private Double activationPrice;
	private Double callbackRate;
	private WorkingType workingType;
	private Boolean priceProtect;
	
	//Constructeurs
	private FutureOrderRequest() {}
	
	//Getters
	public final Double getActivationPrice() {
		return activationPrice;
	}
	
	public final Double getCallbackRate() {
		return callbackRate;
	}
	
	public final Boolean closePosition() {
		return closePosition;
	}
	
	public final PositionSides getPositionSide() {
		return positionSide;
	}
	
	public final Boolean priceProtect() {
		return priceProtect;
	}
	
	public final Boolean reduceOnly() {
		return reduceOnly;
	}
	
	public final WorkingType getWorkingType() {
		return workingType;
	}	
}