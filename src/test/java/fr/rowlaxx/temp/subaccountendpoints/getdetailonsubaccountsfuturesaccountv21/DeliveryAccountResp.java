package fr.rowlaxx.temp.subaccountendpoints.getdetailonsubaccountsfuturesaccountv21;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.getdetailonsubaccountsfuturesaccountv21.deliveryaccountresp.Assets;

import java.util.List;

import org.json.JSONObject;

public class DeliveryAccountResp extends JSavONObject {
	private static final long serialVersionUID = -6320317233636645389L;
	
	//Variables
	private List<Assets> assets;
	private boolean canDeposit;
	private boolean canTrade;
	private boolean canWithdraw;
	private String email;
	private int feeTier;
	private long updateTime;
	
	//Constructeurs
	public DeliveryAccountResp(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<Assets> getAssets() {
		return this.assets;
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