package fr.rowlaxx.temp.subaccountendpoints.getsummaryofsubaccountsfuturesaccountv21;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.getsummaryofsubaccountsfuturesaccountv21.deliveryaccountsummaryresp.SubAccountList;

import java.util.List;

import org.json.JSONObject;

public class DeliveryAccountSummaryResp extends JSavONObject {
	private static final long serialVersionUID = -2854526609527300832L;
	
	//Variables
	private String asset;
	private List<SubAccountList> subAccountList;
	private double totalMarginBalanceOfBTC;
	private double totalUnrealizedProfitOfBTC;
	private double totalWalletBalanceOfBTC;
	
	//Constructeurs
	public DeliveryAccountSummaryResp(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final List<SubAccountList> getSubAccountList() {
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