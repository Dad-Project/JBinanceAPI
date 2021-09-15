package fr.rowlaxx.binanceapi.core.order.spot;

import fr.rowlaxx.binanceapi.core.order.SimpleOrderRequest;

public class SpotOrderRequest extends SimpleOrderRequest<SpotOrderTypes> {
	
	//Variables
	private Double quoteOrderQty;
	private Double icebergQty;
	
	//Constructeurs
	public SpotOrderRequest(SpotOrderTypes type) {
		super(type);
	}
	
	//Getter
	public final Double getIcebergQty() {
		return icebergQty;
	}
	
	public final Double getQuoteOrderQty() {
		return quoteOrderQty;
	}
	
	//Setters
	public void setIcebergQty(Double icebergQty) {
		this.icebergQty = icebergQty;
	}
	
	public void setQuoteOrderQty(Double quoteOrderQty) {
		this.quoteOrderQty = quoteOrderQty;
	}
}
