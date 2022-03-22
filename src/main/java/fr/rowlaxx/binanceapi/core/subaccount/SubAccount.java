package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JsavonObject;

public class SubAccount extends JsavonObject {
	private static final long serialVersionUID = 7666190389359963590L;
	
	//Variables
	private long createTime;
	private String email;
	private boolean isFreeze;
	private boolean isManagedSubAccount;
	private boolean isAssetManagementSubAccount;
	
	//Getters
	public final long getCreateTime() {
		return this.createTime;
	}
	
	public final String getEmail() {
		return this.email;
	}
	
	public final boolean isFreeze() {
		return this.isFreeze;
	}
	
	public final boolean isAssetManagementSubAccount() {
		return isAssetManagementSubAccount;
	}
	
	public final boolean isManagedSubAccount() {
		return isManagedSubAccount;
	}
}