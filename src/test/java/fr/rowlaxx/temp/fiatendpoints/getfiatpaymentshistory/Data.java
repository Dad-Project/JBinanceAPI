package fr.rowlaxx.temp.fiatendpoints.getfiatpaymentshistory;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = 4117718712797747189L;
	
	//Variables
	private long createTime;
	private String cryptoCurrency;
	private String fiatCurrency;
	private double obtainAmount;
	private String orderNo;
	private double price;
	private double sourceAmount;
	private String status;
	private double totalFee;
	private long updateTime;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getCreateTime() {
		return this.createTime;
	}
	
	public final String getCryptoCurrency() {
		return this.cryptoCurrency;
	}
	
	public final String getFiatCurrency() {
		return this.fiatCurrency;
	}
	
	public final double getObtainAmount() {
		return this.obtainAmount;
	}
	
	public final String getOrderNo() {
		return this.orderNo;
	}
	
	public final double getPrice() {
		return this.price;
	}
	
	public final double getSourceAmount() {
		return this.sourceAmount;
	}
	
	public final String getStatus() {
		return this.status;
	}
	
	public final double getTotalFee() {
		return this.totalFee;
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}