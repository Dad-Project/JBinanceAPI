package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.MapKey;
import java.util.Map;

import org.json.JSONObject;

public class SubAccountFuturesCoinMDetail extends JsavonObject {
	private static final long serialVersionUID = -6320317233636645389L;
	
	//Variables
	@MapKey(fieldName = "asset")
	private Map<String, Asset> assets;	private boolean canDeposit;
	private boolean canTrade;
	private boolean canWithdraw;
	private String email;
	private int feeTier;
	private long updateTime;
	
	//Constructeurs
	public SubAccountFuturesCoinMDetail(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Map<String, Asset> getAssets() {
		return this.assets;
	}
	
	public final Asset getAsset(String name) {
		return this.assets.get(name);
	}
	
	public final boolean isCanDeposit() {
		return this.canDeposit;
	}
	
	public final boolean isCanTrade() {
		return this.canTrade;
	}
	
	public final boolean isCanWithdraw() {
		return this.canWithdraw;
	}
	
	public final String getEmail() {
		return this.email;
	}
	
	public final int getFeeTier() {
		return this.feeTier;
	}
	
	public final long getUpdateTime() {
		return this.updateTime;
	}
}