package fr.rowlaxx.temp.walletendpoints.dailyaccountsnapshot1.snapshotvos;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.dailyaccountsnapshot1.snapshotvos.data.UserAssets;

import java.util.List;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = -7974718376590612474L;
	
	//Variables
	private double marginLevel;
	private double totalAssetOfBtc;
	private double totalLiabilityOfBtc;
	private double totalNetAssetOfBtc;
	private List<UserAssets> userAssets;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getMarginLevel() {
		return this.marginLevel;
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
	
	public final List<UserAssets> getUserAssets() {
		return this.userAssets;
	}
}