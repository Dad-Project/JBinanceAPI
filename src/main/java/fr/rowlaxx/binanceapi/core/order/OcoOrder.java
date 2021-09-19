package fr.rowlaxx.binanceapi.core.order;

import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.order.spot.SpotOrder;
import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class OcoOrder<O extends SpotOrder> extends JSavONObject {
	private static final long serialVersionUID = -5128726759871863206L;
	
	//Variables
	private String contingencyType;
	private String listClientOrderId;
	private String listOrderStatus;
	private String listStatusType;
	private int orderListId;
	@JOValue(mandatory = false)
	private List<O> orderReports;
	private List<SimpleOrder> orders;
	private String symbol;
	private long transactionTime;

	//Constructeurs
	public OcoOrder(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getOrderListId() {
		return this.orderListId;
	}
	
	public final List<O> getOrderReports() {
		return this.orderReports;
	}
	
	public final List<SimpleOrder> getOrders() {
		return this.orders;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final long getTransactionTime() {
		return this.transactionTime;
	}
	
	public final String getListClientOrderId() {
		return this.listClientOrderId;
	}
	
	public final String getListOrderStatus() {
		return this.listOrderStatus;
	}
	
	public final String getListStatusType() {
		return this.listStatusType;
	}
	
	public final String getContingencyType() {
		return this.contingencyType;
	}
}