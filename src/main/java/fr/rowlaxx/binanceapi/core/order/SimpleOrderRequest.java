package fr.rowlaxx.binanceapi.core.order;

public abstract class SimpleOrderRequest<T extends OrderTypes> extends OrderRequest<T> {

	//Variables
	private String newClientOrderId;
	private Double stopPrice;
	
	//Constructeurs
	protected SimpleOrderRequest(T type) {
		super(type);
	}
	
	//Getters
	public final Double getStopPrice() {
		return stopPrice;
	}
	
	public final String getNewClientOrderId() {
		return newClientOrderId;
	}
	
	//Setters
	public void setNewClientOrderId(String newClientOrderId) {
		this.newClientOrderId = newClientOrderId;
	}
	
	public void setStopPrice(Double stopPrice) {
		this.stopPrice = stopPrice;
	}
	
}
