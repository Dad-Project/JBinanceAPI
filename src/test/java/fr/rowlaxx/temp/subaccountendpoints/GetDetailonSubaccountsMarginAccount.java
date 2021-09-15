package fr.rowlaxx.temp.subaccountendpoints;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.subaccountendpoints.getdetailonsubaccountsmarginaccount.MarginTradeCoeffVo;
import fr.rowlaxx.temp.subaccountendpoints.getdetailonsubaccountsmarginaccount.MarginUserAssetVoList;

import java.util.List;

import org.json.JSONObject;

public class GetDetailonSubaccountsMarginAccount extends JSavONObject {
	private static final long serialVersionUID = 3889396953371372515L;
	
	//Variables
	private String email;
	private double marginLevel;
	private MarginTradeCoeffVo marginTradeCoeffVo;
	private List<MarginUserAssetVoList> marginUserAssetVoList;
	private double totalAssetOfBtc;
	private double totalLiabilityOfBtc;
	private double totalNetAssetOfBtc;
	
	//Constructeurs
	public GetDetailonSubaccountsMarginAccount(JSONObject json) {
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
	
	public final List<MarginUserAssetVoList> getMarginUserAssetVoList() {
		return this.marginUserAssetVoList;
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