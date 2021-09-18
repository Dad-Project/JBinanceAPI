package fr.rowlaxx.binanceapi.core.order;

public class Basic2OrderRequest<T extends OrderTypes> extends BasicOrderRequest<T> {

	//Builder
	@SuppressWarnings("unchecked")
	protected static class Builder<T extends OrderTypes, R extends Basic2OrderRequest<T>, B extends Builder<T, R, B>> extends BasicOrderRequest.Builder<T, R, B> {

		//Constructeurs
		protected Builder(R request) {
			super(request);
		}
		
		//Setters
		public final B setStopPrice(Double stopPrice) {
			((Basic2OrderRequest<T>)request()).stopPrice = stopPrice;
			return (B) this;
		}

		public final B setNewClientOrderId(String newClientOrderId) {
			((Basic2OrderRequest<?>)request()).newClientOrderId = newClientOrderId;
			return (B) this;
		}
	}
	
	//Constructeurs
	protected Basic2OrderRequest() {}
	
	//Variables
	private String newClientOrderId;
	private Double stopPrice;
	
	//Getters
	public final String getNewClientOrderId() {
		return newClientOrderId;
	}
	
	public final Double getStopPrice() {
		return stopPrice;
	}
}
