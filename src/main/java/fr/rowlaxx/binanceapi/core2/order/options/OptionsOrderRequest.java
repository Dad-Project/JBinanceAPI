package fr.rowlaxx.binanceapi.core2.order.options;

import fr.rowlaxx.binanceapi.core.BasicOrderRequest;

public final class OptionsOrderRequest extends BasicOrderRequest<OptionsOrderTypes> {
	
	//Methodes statiques
	public static Builder newBuilder() {
		return new Builder();
	}
	
	//Builder
	@SuppressWarnings("unused")
	public final static class Builder extends BasicOrderRequest.Builder<OptionsOrderTypes, OptionsOrderRequest, Builder> {

		//Constructeurs
		private Builder() {
			super(new OptionsOrderRequest());
		}
		
		//Setters
		public final Builder setReduceOnly(Boolean reduceOnly) {
			request().reduceOnly = reduceOnly;
			return this;
		}
		
		public final Builder setPostOnly(Boolean postOnly) {
			request().postOnly = postOnly;
			return this;
		}
		
		public final Builder setClientOrderId(String clientOrderId) {
			request().clientOrderId = clientOrderId;
			return this;
		}
	}
	
	//Constructeurs
	private OptionsOrderRequest() {}
	
	//Variables
	private Boolean reduceOnly;
	private Boolean postOnly;
	private String clientOrderId;
	
	//Getters
	public final String getClientOrderId() {
		return clientOrderId;
	}
	
	public final Boolean postOnly() {
		return postOnly;
	}
	
	public final Boolean reduceOnly() {
		return reduceOnly;
	}
}
