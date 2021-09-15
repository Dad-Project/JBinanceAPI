package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.MapKey;

import java.util.Map;

import org.json.JSONObject;

public class SubAccountsFutureCoinMSummary extends JSavONObject {
	private static final long serialVersionUID = -2854526609527300832L;
	
	//Variables
	private String asset;
	@MapKey(fieldName = "email")
	private Map<String, AccountAsset> subAccountList;	private double totalMarginBalanceOfBTC;
	private double totalUnrealizedProfitOfBTC;
	private double totalWalletBalanceOfBTC;
	
	//Constructeurs
	public SubAccountsFutureCoinMSummary(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	
	public final Map<String, AccountAsset> getSubAccountList() {
		return this.subAccountList;
	}
	
	public final double getTotalMarginBalanceOfBTC() {
		return this.totalMarginBalanceOfBTC;
	}
	
	public final double getTotalUnrealizedProfitOfBTC() {
		return this.totalUnrealizedProfitOfBTC;
	}
	
	public final double getTotalWalletBalanceOfBTC() {
		return this.totalWalletBalanceOfBTC;
	}
}