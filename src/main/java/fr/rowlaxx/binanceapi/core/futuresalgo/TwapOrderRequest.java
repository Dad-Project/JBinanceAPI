package fr.rowlaxx.binanceapi.core.futuresalgo;

public class TwapOrderRequest extends FuturesAlgoOrderRequest {

	//Methodes statiques
	public static Builder newBuilder() {
		return new Builder();
	}
	
	//Builder
	public static class Builder extends BaseBuilder<Builder, TwapOrderRequest>{
		
		//Constructeurs
		private Builder() {
			super(new TwapOrderRequest());
		}
		
		//Setters
		public Builder setUrgency(Long duration) {
			request().duration = duration;
			return this;
		}
	}
	
	//Variables
	private Long duration;
	
	//Getters
	public Long getDuration() {
		return duration;
	}
}
