package fr.rowlaxx.binanceapi.core.spot.wallet;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class AssetDetail extends JsavonObject {
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