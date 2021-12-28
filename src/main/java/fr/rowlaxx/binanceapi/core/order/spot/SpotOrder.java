package fr.rowlaxx.binanceapi.core.order.spot;

import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.order.BasicOrder;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class SpotOrder extends BasicOrder<SpotOrderTypes> {
	private static final long serialVersionUID = 6515467018603198407L;
	
	//Variables
	@JOValue(mandatory = false)
	private Long orderListId;
	@JOValue(mandatory = false)
	private Double cummulativeQuoteQty;
	@JOValue(mandatory = false)
	private Double origQuoteOrderQty;
	@JOValue(mandatory = false)
	private List<Fill> fills;
	@JOValue(mandatory = false)
	private Double icebergQty;
	@JOValue(mandatory = false)
	private Boolean isWorking;
	
	//Constructeurs
	public SpotOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Long getOrderListId() {
		return orderListId;
	}
	
	public final Double getCummulativeQuoteQty() {
		return cummulativeQuoteQty;
	}
	
	public final List<Fill> getFills() {
		return fills;
	}
	
	public final Double getIcebergQty() {
		return icebergQty;
	}
	
	public final Boolean getIsWorking() {
		return isWorking;
	}
	
	public final Double getOrigQuoteOrderQty() {
		return origQuoteOrderQty;
	}
}