package fr.rowlaxx.binanceapi.core.order.spot;

import fr.rowlaxx.binanceapi.core.order.Order;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

import java.util.List;

import org.json.JSONObject;

public class SpotOrder extends Order<SpotOrderTypes> {
	private static final long serialVersionUID = 6515467018603198407L;
	
	//Variables
	@JOValue(mandatory = false) private Double cummulativeQuoteQty;
	@JOValue(mandatory = false) private Double executedQty;
	private int orderId;
	private int orderListId;
	@JOValue(mandatory = false) private Double origQty;
	@JOValue(mandatory = false) private Long transactTime;
	@JOValue(mandatory = false) private List<Fill> fills;
	@JOValue(mandatory = false) private String origClientOrderId;
	@JOValue(mandatory = false) private Double stopPrice;
	@JOValue(mandatory = false) private Double icebergQty;
	@JOValue(mandatory = false) private Long time;
	@JOValue(mandatory = false) private Long updateTime;
	@JOValue(mandatory = false) private Boolean isWorking;
	@JOValue(mandatory = false) private Double origQuoteOrderQty;
	
	//Constructeurs
	public SpotOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Double getCummulativeQuoteQty() {
		return this.cummulativeQuoteQty;
	}
	
	public final Double getExecutedQty() {
		return this.executedQty;
	}
	
	public final int getOrderId() {
		return this.orderId;
	}
	
	public final int getOrderListId() {
		return this.orderListId;
	}
	
	public final Double getOrigQty() {
		return this.origQty;
	}
	
	public final Long getTransactTime() {
		return this.transactTime;
	}
	
	public final List<Fill> getFills(){
		return this.fills;
	}
	
	public final String getOrigClientOrderId() {
		return this.origClientOrderId;
	}
	
	public final Double getIcebergQty() {
		return icebergQty;
	}
	
	public final Double getStopPrice() {
		return stopPrice;
	}
	
	public final Boolean isWorking() {
		return isWorking;
	}
	
	public final Double getOrigQuoteOrderQty() {
		return origQuoteOrderQty;
	}
	
	public final Long getTime() {
		return time;
	}
	
	public final Long getUpdateTime() {
		return updateTime;
	}
}