package fr.rowlaxx.binanceapi.core.fiat;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

abstract class FiatTransfer extends JsavonObject {
	private static final long serialVersionUID = 1851902082203737743L;

	//Variables
	private String orderNo;
	private String status;
	private double totalFee;
	private long updateTime;
	private long createTime;
	private String fiatCurrency;
	
	//Consrtucteurs
	public FiatTransfer(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getCreateTime() {
		return this.createTime;
	}
	
	public final String getFiatCurrency() {
		return this.fiatCurrency;
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