package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.marginaccounttrade.queryisolatedmarginaccountinfo.Assets;

import java.util.List;

import org.json.JSONObject;

public class QueryIsolatedMarginAccountInfo extends JSavONObject {
	private static final long serialVersionUID = -8384196696274874129L;
	
	//Variables
	private List<Assets> assets;
	private double totalAssetOfBtc;
	private double totalLiabilityOfBtc;
	private double totalNetAssetOfBtc;
	
	//Constructeurs
	public QueryIsolatedMarginAccountInfo(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<Assets> getAssets() {
		return this.assets;
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