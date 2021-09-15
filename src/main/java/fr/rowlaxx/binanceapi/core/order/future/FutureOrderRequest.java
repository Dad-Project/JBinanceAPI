package fr.rowlaxx.binanceapi.core.order.future;

import fr.rowlaxx.binanceapi.core.order.SimpleOrderRequest;

public class FutureOrderRequest extends SimpleOrderRequest<FutureOrderTypes> {

	//Variables
	private PositionSides positionSide;
	private Boolean reduceOnly;
	private Double activationPrice;
	private Double callbackRate;
	private WorkingType workingType;
	private Boolean priceProtect;
	
	//Constructeurs
	protected FutureOrderRequest(FutureOrderTypes type) {
		super(type);
	}
	
	//Getters
	public final Double getActivationPrice() {
		return activationPrice;
	}
	
	public final Double getCallbackRate() {
		return callbackRate;
	}
	
	public final PositionSides getPositionSide() {
		return positionSide;
	}
	
	public final Boolean getPriceProtect() {
		return priceProtect;
	}
	
	public final Boolean getReduceOnly() {
		return reduceOnly;
	}
	
	public final WorkingType getWorkingType() {
		return workingType;
	}
	
	//Setters
	protected void setActivationPrice(Double activationPrice) {
		this.activationPrice = activationPrice;
	}
	
	protected void setCallbackRate(Double callbackRate) {
		this.callbackRate = callbackRate;
	}
	
	protected void setPositionSide(PositionSides positionSide) {
		this.positionSide = positionSide;
	}
	
	protected void setPriceProtect(Boolean priceProtect) {
		this.priceProtect = priceProtect;
	}
	
	protected void setReduceOnly(Boolean reduceOnly) {
		this.reduceOnly = reduceOnly;
	}
	
	protected void setWorkingType(WorkingType workingType) {
		this.workingType = workingType;
	}	
}
