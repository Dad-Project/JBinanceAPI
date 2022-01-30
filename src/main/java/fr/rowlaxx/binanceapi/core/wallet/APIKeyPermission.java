package fr.rowlaxx.binanceapi.core.wallet;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class APIKeyPermission extends JsavonObject {
	private static final long serialVersionUID = 7486596936335182547L;
	
	//Variables
	private long createTime;
	private boolean enableFutures;
	private boolean enableInternalTransfer;
	private boolean enableMargin;
	private boolean enableReading;
	private boolean enableSpotAndMarginTrading;
	private boolean enableVanillaOptions;
	private boolean enableWithdrawals;
	private boolean ipRestrict;
	private boolean permitsUniversalTransfer;
	@JOValue(mandatory = false)
	private Long tradingAuthorityExpirationTime;
	
	//Constructeurs
	public APIKeyPermission(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final long getCreateTime() {
		return this.createTime;
	}
	
	public final boolean isEnableFutures() {
		return this.enableFutures;
	}
	
	public final boolean isEnableInternalTransfer() {
		return this.enableInternalTransfer;
	}
	
	public final boolean isEnableMargin() {
		return this.enableMargin;
	}
	
	public final boolean isEnableReading() {
		return this.enableReading;
	}
	
	public final boolean isEnableSpotAndMarginTrading() {
		return this.enableSpotAndMarginTrading;
	}
	
	public final boolean isEnableVanillaOptions() {
		return this.enableVanillaOptions;
	}
	
	public final boolean isEnableWithdrawals() {
		return this.enableWithdrawals;
	}
	
	public final boolean isIpRestrict() {
		return this.ipRestrict;
	}
	
	public final boolean isPermitsUniversalTransfer() {
		return this.permitsUniversalTransfer;
	}
	
	public final Long getTradingAuthorityExpirationTime() {
		return this.tradingAuthorityExpirationTime;
	}
}