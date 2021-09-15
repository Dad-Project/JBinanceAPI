package fr.rowlaxx.temp.c2cendpoints.getc2ctradehistory;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = 8374233288495381052L;
	
	//Variables
	private String advertisementRole;
	private double advNo;
	private double amount;
	private String asset;
	private int commission;
	private String counterPartNickName;
	private long createTime;
	private String fiat;
	private String fiatSymbol;
	private double orderNumber;
	private String orderStatus;
	private double totalPrice;
	private String tradeType;
	private double unitPrice;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAdvertisementRole() {
		return this.advertisementRole;
	}
	
	public final double getAdvNo() {
		return this.advNo;
	}
	
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getAsset() {
		return this.asset;
	}
	
	public final int getCommission() {
		return this.commission;
	}
	
	public final String getCounterPartNickName() {
		return this.counterPartNickName;
	}
	
	public final long getCreateTime() {
		return this.createTime;
	}
	
	public final String getFiat() {
		return this.fiat;
	}
	
	public final String getFiatSymbol() {
		return this.fiatSymbol;
	}
	
	public final double getOrderNumber() {
		return this.orderNumber;
	}
	
	public final String getOrderStatus() {
		return this.orderStatus;
	}
	
	public final double getTotalPrice() {
		return this.totalPrice;
	}
	
	public final String getTradeType() {
		return this.tradeType;
	}
	
	public final double getUnitPrice() {
		return this.unitPrice;
	}
}