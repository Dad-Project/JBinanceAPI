package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.marginaccounttrade.marginaccountnewoco.OrderReports;
import fr.rowlaxx.temp.marginaccounttrade.marginaccountnewoco.Orders;

import java.util.List;

import org.json.JSONObject;

public class MarginAccountNewOCO extends JSavONObject {
	private static final long serialVersionUID = -423159239247907955L;
	
	//Variables
	private String contingencyType;
	private boolean isIsolated;
	private String listClientOrderId;
	private String listOrderStatus;
	private String listStatusType;
	private int marginBuyBorrowAmount;
	private String marginBuyBorrowAsset;
	private int orderListId;
	private List<OrderReports> orderReports;
	private List<Orders> orders;
	private String symbol;
	private long transactionTime;
	
	//Constructeurs
	public MarginAccountNewOCO(JSONObject json) {
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
	
	public final int getMarginBuyBorrowAmount() {
		return this.marginBuyBorrowAmount;
	}
	
	public final String getMarginBuyBorrowAsset() {
		return this.marginBuyBorrowAsset;
	}
	
	public final int getOrderListId() {
		return this.orderListId;
	}
	
	public final List<OrderReports> getOrderReports() {
		return this.orderReports;
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