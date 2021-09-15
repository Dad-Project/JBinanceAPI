package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.jsavon.annotations.MapKey;
import java.util.Map;

import org.json.JSONObject;

public class SubAccountsMarginSummary extends JSavONObject {
	private static final long serialVersionUID = 4510694267817474504L;
	
	//Variables
	@MapKey(fieldName = "email")
	private Map<String, SubAccountTotal> subAccountList;
	private double totalAssetOfBtc;
	private double totalLiabilityOfBtc;
	private double totalNetAssetOfBtc;
	
	//Constructeurs
	public SubAccountsMarginSummary(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Map<String, SubAccountTotal> getSubAccountTotals() {
		return this.subAccountList;
	}
	
	public final SubAccountTotal getSubAccountTotal(String email) {
		return this.subAccountList.get(email);
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