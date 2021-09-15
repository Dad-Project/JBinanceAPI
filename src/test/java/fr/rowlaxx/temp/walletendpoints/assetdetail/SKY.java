package fr.rowlaxx.temp.walletendpoints.assetdetail;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class SKY extends JSavONObject {
	private static final long serialVersionUID = 3505933138551248956L;
	
	//Variables
	private boolean depositStatus;
	private double minWithdrawAmount;
	private double withdrawFee;
	private boolean withdrawStatus;
	
	//Constructeurs
	public SKY(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final boolean isDepositStatus() {
		return this.depositStatus;
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