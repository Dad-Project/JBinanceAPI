package fr.rowlaxx.binanceapi.core.margin;

import fr.rowlaxx.binanceapi.core.wallet.margin.UserAsset;
import fr.rowlaxx.jsavon.JsavonObject;
import fr.rowlaxx.jsavon.annotations.MapKey;

import java.util.Map;

import org.json.JSONObject;

public class CrossMarginAccountDetails extends JsavonObject {
	private static final long serialVersionUID = -8707527584962892528L;
	
	//Variables
	private boolean borrowEnabled;
	private double marginLevel;
	private double totalAssetOfBtc;
	private double totalLiabilityOfBtc;
	private double totalNetAssetOfBtc;
	private boolean tradeEnabled;
	private boolean transferEnabled;
	@MapKey(fieldName = "asset")
	private Map<String, UserAsset> userAssets;
	
	//Constructeurs
	public CrossMarginAccountDetails(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final boolean isBorrowEnabled() {
		return this.borrowEnabled;
	}
	
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
	
	public final boolean isTradeEnabled() {
		return this.tradeEnabled;
	}
	
	public final boolean isTransferEnabled() {
		return this.transferEnabled;
	}
	
	public final Map<String, UserAsset> getUserAssets() {
		return this.userAssets;
	}
	
	public final UserAsset getUserAsset(String asset) {
		return this.userAssets.get(asset);
	}
}