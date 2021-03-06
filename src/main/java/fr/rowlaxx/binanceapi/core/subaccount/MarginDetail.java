package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.binanceapi.core.UserAsset;
import fr.rowlaxx.jsavon.JsavonObject;

import java.util.Map;

import org.json.JSONObject;

public class MarginDetail extends JsavonObject {
	private static final long serialVersionUID = 3889396953371372515L;
	
	//Variables
	private String email;
	private double marginLevel;
	private MarginCoeffVo marginTradeCoeffVo;
	private Map<String, UserAsset> marginUserAssetVoList;
	private double totalAssetOfBtc;
	private double totalLiabilityOfBtc;
	private double totalNetAssetOfBtc;
	
	//Constructeurs
	public MarginDetail(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getEmail() {
		return this.email;
	}
	
	public final double getMarginLevel() {
		return this.marginLevel;
	}
	
	public final MarginCoeffVo getMarginTradeCoeffVo() {
		return this.marginTradeCoeffVo;
	}
	
	public final Map<String, UserAsset> getMarginUserAssets() {
		return this.marginUserAssetVoList;
	}
	
	public final UserAsset getMarginUserAsset(String name) {
		return this.marginUserAssetVoList.get(name);
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