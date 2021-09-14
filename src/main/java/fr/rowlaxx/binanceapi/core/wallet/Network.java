package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class Network extends JSavONObject {
	private static final long serialVersionUID = -8013201329341085363L;

	//Variables
	@JOValue(mandatory = false) private String specialTips;
	@JOValue private String addressRegex, coin, depositDesc, memoRegex, name, network, withdrawDesc;
	@JOValue private boolean depositEnable, isDefault, resetAddressStatus, withdrawEnable, sameAddress;
	@JOValue private int minConfirm, unLockConfirm;
	@JOValue private double withdrawFee, withdrawIntegerMultiple, withdrawMax, withdrawMin;
	
	//Constructeurs
	public Network(JSONObject json) {
		super(json);
	}
	
	//Getters
	public String getAddressRegex() {
		return addressRegex;
	}
	
	public String getCoin() {
		return coin;
	}
	
	public String getDepositDesc() {
		return depositDesc;
	}
	
	public String getMemoRegex() {
		return memoRegex;
	}
	
	public int getMinConfirm() {
		return minConfirm;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNetwork() {
		return network;
	}
	
	public String getSpecialTips() {
		return specialTips;
	}
	
	public int getUnLockConfirm() {
		return unLockConfirm;
	}
	
	public String getWithdrawDesc() {
		return withdrawDesc;
	}
	
	public double getWithdrawFee() {
		return withdrawFee;
	}
	
	public double getWithdrawIntegerMultiple() {
		return withdrawIntegerMultiple;
	}
	
	public double getWithdrawMax() {
		return withdrawMax;
	}
	
	public double getWithdrawMin() {
		return withdrawMin;
	}
	
	public boolean isDefault() {
		return isDefault;
	}
	
	public boolean isDepositEnable() {
		return depositEnable;
	}
	
	public boolean isResetAddressStatus() {
		return resetAddressStatus;
	}
	
	public boolean isSameAddress() {
		return sameAddress;
	}
	
	public boolean isWithdrawEnable() {
		return withdrawEnable;
	}
}
