package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.MapKey;
import java.util.Map;

import org.json.JSONObject;

public class MarginSummary extends JsavonObject {
	private static final long serialVersionUID = 4510694267817474504L;
	
	//Variables
	@MapKey(fieldName = "email")
	private Map<String, MarginTotal> subAccountList;
	private double totalAssetOfBtc;
	private double totalLiabilityOfBtc;
	private double totalNetAssetOfBtc;
	
	//Constructeurs
	public MarginSummary(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final Map<String, MarginTotal> getSubAccountTotals() {
		return this.subAccountList;
	}
	
	public final MarginTotal getSubAccountTotal(String email) {
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