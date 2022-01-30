package fr.rowlaxx.binanceapi.core.wallet;

import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class CoinInformation extends JsavonObject {
	private static final long serialVersionUID = -9101276779382470147L;
	
	//Variables
	private String coin;
	private boolean depositAllEnable;
	private double free;
	private double freeze;
	private double ipoable;
	private double ipoing;
	private boolean isLegalMoney;
	private double locked;
	private String name;
	private List<Network> networkList;
	private double storage;
	private boolean trading;
	private boolean withdrawAllEnable;
	private double withdrawing;
	
	//Constructeurs
	public CoinInformation(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getCoin() {
		return this.coin;
	}
	
	public final boolean isDepositAllEnable() {
		return this.depositAllEnable;
	}
	
	public final double getFree() {
		return this.free;
	}
	
	public final double getFreeze() {
		return this.freeze;
	}
	
	public final double getIpoable() {
		return this.ipoable;
	}
	
	public final double getIpoing() {
		return this.ipoing;
	}
	
	public final boolean isLegalMoney() {
		return this.isLegalMoney;
	}
	
	public final double getLocked() {
		return this.locked;
	}
	
	public final String getName() {
		return this.name;
	}
	
	public final List<Network> getNetworkList() {
		return this.networkList;
	}
	
	public final double getStorage() {
		return this.storage;
	}
	
	public final boolean isTrading() {
		return this.trading;
	}
	
	public final boolean isWithdrawAllEnable() {
		return this.withdrawAllEnable;
	}
	
	public final double getWithdrawing() {
		return this.withdrawing;
	}
}