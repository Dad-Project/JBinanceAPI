package fr.rowlaxx.binanceapi.core.subaccount;

import fr.rowlaxx.binanceapi.core.wallet.margin.UserAsset;
import fr.rowlaxx.jsavon.JSavONObject;

import java.util.Map;

import org.json.JSONObject;

public class SubAccountMarginDetail extends JSavONObject {
	private static final long serialVersionUID = 3889396953371372515L;
	
	//Variables
	private String email;
	private double marginLevel;
	private MarginTradeCoeffVo marginTradeCoeffVo;
	private Map<String, UserAsset> marginUserAssetVoList;
	private double totalAssetOfBtc;
	private double totalLiabilityOfBtc;
	private double totalNetAssetOfBtc;
	
	//Constructeurs
	public SubAccountMarginDetail(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getEmail() {
		return this.email;
	}
	
	public final double getMarginLevel() {
		return this.marginLevel;
	}
	
	public final MarginTradeCoeffVo getMarginTradeCoeffVo() {
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