package fr.rowlaxx.binanceapi.core.futuresalgo;

public class VPOrderRequest extends FuturesAlgoOrderRequest {

	//Methodes statiques
	public static Builder newBuilder() {
		return new Builder();
	}
	
	//Builder
	public static class Builder extends BaseBuilder<Builder, VPOrderRequest>{
		
		//Constructeurs
		private Builder() {
			super(new VPOrderRequest());
		}
		
		//Setters
		public Builder setUrgency(Urgency urgency) {
			request().urgency = urgency;
			return this;
		}
	}
	
	//Variables
	private Urgency urgency;
	
	//Getters
	public Urgency getUrgency() {
		return urgency;
	}
}
