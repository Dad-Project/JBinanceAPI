package fr.rowlaxx.temp.walletendpoints.assetdetail;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CTR extends JSavONObject {
	private static final long serialVersionUID = 4486608431669298205L;
	
	//Variables
	private boolean depositStatus;
	private String depositTip;
	private double minWithdrawAmount;
	private int withdrawFee;
	private boolean withdrawStatus;
	
	//Constructeurs
	public CTR(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final boolean isDepositStatus() {
		return this.depositStatus;
	}
	
	public final String getDepositTip() {
		return this.depositTip;
	}
	
	public final double getMinWithdrawAmount() {
		return this.minWithdrawAmount;
	}
	
	public final int getWithdrawFee() {
		return this.withdrawFee;
	}
	
	public final boolean isWithdrawStatus() {
		return this.withdrawStatus;
	}
}