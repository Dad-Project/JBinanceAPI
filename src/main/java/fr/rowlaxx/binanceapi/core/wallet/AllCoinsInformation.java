package fr.rowlaxx.binanceapi.core.wallet;

import java.util.List;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class AllCoinsInformation extends JSavONObject {
	private static final long serialVersionUID = -7811395121040825462L;

	//Variables
	@JOValue private String coin, name;
	@JOValue private boolean depositAllEnable, isLegalMoney, trading, withdrawAllEnable;
	@JOValue private double free, freeze, ipoable, ipoing, locked, storage, withdrawing;
	@JOValue private List<Network> networkList;
	
	//Constructeurs
	public AllCoinsInformation(JSONObject json) {
		super(json);
	}
	
	//Getters
	public String getCoin() {
		return coin;
	}
	
	public double getFree() {
		return free;
	}
	
	public double getFreeze() {
		return freeze;
	}
	
	public double getIpoable() {
		return ipoable;
	}
	
	public double getIpoing() {
		return ipoing;
	}
	
	public double getLocked() {
		return locked;
	}
	
	public String getName() {
		return name;
	}
	
	public double getStorage() {
		return storage;
	}
	
	public double getWithdrawing() {
		return withdrawing;
	}
	
	public boolean isDepositAllEnable() {
		return depositAllEnable;
	}
	
	public boolean isLegalMoney() {
		return isLegalMoney;
	}
	
	public boolean isTrading() {
		return trading;
	}
	
	public boolean isWithdrawAllEnable() {
		return withdrawAllEnable;
	}
}
