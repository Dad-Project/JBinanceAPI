package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.marginaccounttrade.querycrossmarginaccountdetails.UserAssets;

import java.util.List;

import org.json.JSONObject;

public class QueryCrossMarginAccountDetails extends JSavONObject {
	private static final long serialVersionUID = -8707527584962892528L;
	
	//Variables
	private boolean borrowEnabled;
	private double marginLevel;
	private double totalAssetOfBtc;
	private double totalLiabilityOfBtc;
	private double totalNetAssetOfBtc;
	private boolean tradeEnabled;
	private boolean transferEnabled;
	private List<UserAssets> userAssets;
	
	//Constructeurs
	public QueryCrossMarginAccountDetails(JSONObject json) {
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
	
	public final List<UserAssets> getUserAssets() {
		return this.userAssets;
	}
}