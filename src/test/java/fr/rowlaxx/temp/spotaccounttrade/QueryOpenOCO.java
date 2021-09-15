package fr.rowlaxx.temp.spotaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.spotaccounttrade.queryopenoco.Orders;

import java.util.List;

import org.json.JSONObject;

public class QueryOpenOCO extends JSavONObject {
	private static final long serialVersionUID = -7903069083147501817L;
	
	//Variables
	private String contingencyType;
	private String listClientOrderId;
	private String listOrderStatus;
	private String listStatusType;
	private int orderListId;
	private List<Orders> orders;
	private String symbol;
	private long transactionTime;
	
	//Constructeurs
	public QueryOpenOCO(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getContingencyType() {
		return this.contingencyType;
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
	
	public final int getOrderListId() {
		return this.orderListId;
	}
	
	public final List<Orders> getOrders() {
		return this.orders;
	}
	
	public final String getSymbol() {
		return this.symbol;
	}
	
	public final long getTransactionTime() {
		return this.transactionTime;
	}
}