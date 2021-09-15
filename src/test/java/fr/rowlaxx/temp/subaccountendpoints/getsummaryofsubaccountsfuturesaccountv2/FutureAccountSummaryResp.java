package fr.rowlaxx.temp.subaccountendpoints.getsummaryofsubaccountsfuturesaccountv2;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.getsummaryofsubaccountsfuturesaccountv2.futureaccountsummaryresp.SubAccountList;

import java.util.List;

import org.json.JSONObject;

public class FutureAccountSummaryResp extends JSavONObject {
	private static final long serialVersionUID = -3498531546215782947L;
	
	//Variables
	private String asset;
	private List<SubAccountList> subAccountList;
	private double totalInitialMargin;
	private double totalMaintenanceMargin;
	private double totalMarginBalance;
	private double totalOpenOrderInitialMargin;
	private double totalPositionInitialMargin;
	private double totalUnrealizedProfit;
	private double totalWalletBalance;
	
	//Constructeurs
	public FutureAccountSummaryResp(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final List<SubAccountList> getSubAccountList() {
		return this.subAccountList;
	}
	
	public final double getTotalInitialMargin() {
		return this.totalInitialMargin;
	}
	
	public final double getTotalMaintenanceMargin() {
		return this.totalMaintenanceMargin;
	}
	
	public final double getTotalMarginBalance() {
		return this.totalMarginBalance;
	}
	
	public final double getTotalOpenOrderInitialMargin() {
		return this.totalOpenOrderInitialMargin;
	}
	
	public final double getTotalPositionInitialMargin() {
		return this.totalPositionInitialMargin;
	}
	
	public final double getTotalUnrealizedProfit() {
		return this.totalUnrealizedProfit;
	}
	
	public final double getTotalWalletBalance() {
		return this.totalWalletBalance;
	}
}