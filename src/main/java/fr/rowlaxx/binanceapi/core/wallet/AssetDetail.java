package fr.rowlaxx.binanceapi.core.wallet;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

import org.json.JSONObject;

public class AssetDetail extends JSavONObject {
	private static final long serialVersionUID = 4486608431669298205L;
	
	//Variables
	private boolean depositStatus;
	@JOValue(mandatory = false)
	private String depositTip;
	private double minWithdrawAmount;
	private double withdrawFee;
	private boolean withdrawStatus;
	
	//Constructeurs
	public AssetDetail(JSONObject json) {
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
	
	public final double getWithdrawFee() {
		return this.withdrawFee;
	}
	
	public final boolean isWithdrawStatus() {
		return this.withdrawStatus;
	}
}