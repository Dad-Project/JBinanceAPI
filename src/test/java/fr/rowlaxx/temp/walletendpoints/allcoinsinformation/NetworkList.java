package fr.rowlaxx.temp.walletendpoints.allcoinsinformation;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class NetworkList extends JSavONObject {
	private static final long serialVersionUID = 2350702230814448458L;
	
	//Variables
	private String addressRegex;
	private String coin;
	private String depositDesc;
	private boolean depositEnable;
	private boolean isDefault;
	private String memoRegex;
	private int minConfirm;
	private String name;
	private String network;
	private boolean resetAddressStatus;
	private boolean sameAddress;
	private String specialTips;
	private int unLockConfirm;
	private String withdrawDesc;
	private boolean withdrawEnable;
	private double withdrawFee;
	private double withdrawIntegerMultiple;
	private double withdrawMax;
	private double withdrawMin;
	
	//Constructeurs
	public NetworkList(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAddressRegex() {
		return this.addressRegex;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final String getDepositDesc() {
		return this.depositDesc;
	}
	
	public final boolean isDepositEnable() {
		return this.depositEnable;
	}
	
	public final boolean isDefault() {
		return this.isDefault;
	}
	
	public final String getMemoRegex() {
		return this.memoRegex;
	}
	
	public final int getMinConfirm() {
		return this.minConfirm;
	}
	
	public final String getName() {
		return this.name;
	}
	
	public final String getNetwork() {
		return this.network;
	}
	
	public final boolean isResetAddressStatus() {
		return this.resetAddressStatus;
	}
	
	public final boolean isSameAddress() {
		return this.sameAddress;
	}
	
	public final String getSpecialTips() {
		return this.specialTips;
	}
	
	public final int getUnLockConfirm() {
		return this.unLockConfirm;
	}
	
	public final String getWithdrawDesc() {
		return this.withdrawDesc;
	}
	
	public final boolean isWithdrawEnable() {
		return this.withdrawEnable;
	}
	
	public final double getWithdrawFee() {
		return this.withdrawFee;
	}
	
	public final double getWithdrawIntegerMultiple() {
		return this.withdrawIntegerMultiple;
	}
	
	public final double getWithdrawMax() {
		return this.withdrawMax;
	}
	
	public final double getWithdrawMin() {
		return this.withdrawMin;
	}
}