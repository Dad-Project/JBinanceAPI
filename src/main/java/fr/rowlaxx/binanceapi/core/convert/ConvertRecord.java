package fr.rowlaxx.binanceapi.core.convert;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.OrderStatus;
import fr.rowlaxx.jsavon.JsavonObject;

public class ConvertRecord extends JsavonObject {
	private static final long serialVersionUID = 4636073296914441505L;

	private String quoteId;
	private long orderId;
	private OrderStatus status;
	private String fromAsset;
	private String toAsset;
	private double fromAmount;
	private double toAmount;
	private double ratio;
	private double inverseRatio;
	private long createTime;
	
	public ConvertRecord(JSONObject json) {
		super(json);
	}
	
	public final long getCreateTime() {
		return createTime;
	}
	
	public final double getFromAmount() {
		return fromAmount;
	}
	
	public final String getFromAsset() {
		return fromAsset;
	}
	
	public final double getInverseRatio() {
		return inverseRatio;
	}
	
	public final long getOrderId() {
		return orderId;
	}
	
	public final String getQuoteId() {
		return quoteId;
	}
	
	public final double getRatio() {
		return ratio;
	}
	
	public final OrderStatus getStatus() {
		return status;
	}
	
	public final double getToAmount() {
		return toAmount;
	}
	
	public final String getToAsset() {
		return toAsset;
	}
}
