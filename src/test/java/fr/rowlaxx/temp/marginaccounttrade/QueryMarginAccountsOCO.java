package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.marginaccounttrade.querymarginaccountsoco.Orders;

import java.util.List;

import org.json.JSONObject;

public class QueryMarginAccountsOCO extends JSavONObject {
	private static final long serialVersionUID = 6402100945657365703L;
	
	//Variables
	private String contingencyType;
	private boolean isIsolated;
	private String listClientOrderId;
	private String listOrderStatus;
	private String listStatusType;
	private int orderListId;
	private List<Orders> orders;
	private String symbol;
	private long transactionTime;
	
	//Constructeurs
	public QueryMarginAccountsOCO(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getContingencyType() {
		return this.contingencyType;
	}
	
	public final boolean isIsolated() {
		return this.isIsolated;
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