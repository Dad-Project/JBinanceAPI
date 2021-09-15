package fr.rowlaxx.temp.fiatendpoints.getfiatdepositwithdrawhistory;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = 7805426192193016213L;
	
	//Variables
	private double amount;
	private long createTime;
	private String fiatCurrency;
	private double indicatedAmount;
	private String method;
	private String orderNo;
	private String status;
	private double totalFee;
	private long updateTime;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getAmount() {
		return this.amount;
	}
	
	public final long getCreateTime() {
		return this.createTime;
	}
	
	public final String getFiatCurrency() {
		return this.fiatCurrency;
	}
	
	public final double getIndicatedAmount() {
		return this.indicatedAmount;
	}
	
	public final String getMethod() {
		return this.method;
	}
	
	public final String getOrderNo() {
		return this.orderNo;
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