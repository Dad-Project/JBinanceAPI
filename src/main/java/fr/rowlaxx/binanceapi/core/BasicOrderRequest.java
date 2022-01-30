package fr.rowlaxx.binanceapi.core;

import java.util.Objects;

public abstract class BasicOrderRequest<T extends OrderTypes> extends OrderRequest {

	//Builder
	@SuppressWarnings("unchecked")
	protected static class Builder<T extends OrderTypes, R extends BasicOrderRequest<T>, B extends Builder<T, R, B>> extends OrderRequest.Builder<R, B> {

		//Constructeurs
		protected Builder(R request) {
			super(request);
		}

		//Methodes
		@Override
		protected void checkBuild() {
			super.checkBuild();
			Objects.requireNonNull(((BasicOrderRequest<T>)request()).type, "type may not be null.");
		}
		
		//Setters
		public final B setType(T type) {
			((BasicOrderRequest<T>)request()).type = type;
			return (B) this;
		}
		
		public final B setTimeInForce(TimeInForce timeInForce) {
			((BasicOrderRequest<?>)request()).timeInForce = timeInForce;
			return (B) this;
		}
	}
	
	//Variables
	private T type;
	private TimeInForce timeInForce;
	
	//Constructeurs
	protected BasicOrderRequest() {}
	
	//Getters
	public final TimeInForce getTimeInForce() {
		return timeInForce;
	}
	
	public final T getType() {
		return type;
	}
}
