package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.getsummaryofsubaccountsmarginaccount.SubAccountList;

import java.util.List;

import org.json.JSONObject;

public class GetSummaryofSubaccountsMarginAccount extends JSavONObject {
	private static final long serialVersionUID = 4510694267817474504L;
	
	//Variables
	private List<SubAccountList> subAccountList;
	private double totalAssetOfBtc;
	private double totalLiabilityOfBtc;
	private double totalNetAssetOfBtc;
	
	//Constructeurs
	public GetSummaryofSubaccountsMarginAccount(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<SubAccountList> getSubAccountList() {
		return this.subAccountList;
	}
	
	public final double getTotalAssetOfBtc() {
		return this.totalAssetOfBtc;
	}
	
	public final double getTotalLiabilityOfBtc() {
		return this.totalLiabilityOfBtc;
	}
	
	public final double getTotalNetAssetOfBtc() {
		return this.totalNetAssetOfBtc;
	}
}