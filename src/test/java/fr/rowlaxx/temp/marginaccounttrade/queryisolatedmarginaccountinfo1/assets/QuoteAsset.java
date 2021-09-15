package fr.rowlaxx.temp.marginaccounttrade.queryisolatedmarginaccountinfo1.assets;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class QuoteAsset extends JSavONObject {
	private static final long serialVersionUID = -486468721490296089L;
	
	//Variables
	private String asset;
	private double borrowed;
	private boolean borrowEnabled;
	private double free;
	private double interest;
	private double locked;
	private double netAsset;
	private double netAssetOfBtc;
	private boolean repayEnabled;
	private double totalAsset;
	
	//Constructeurs
	public QuoteAsset(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getBorrowed() {
		return this.borrowed;
	}
	
	public final boolean isBorrowEnabled() {
		return this.borrowEnabled;
	}
	
	public final double getFree() {
		return this.free;
	}
	
	public final double getInterest() {
		return this.interest;
	}
	
	public final double getLocked() {
		return this.locked;
	}
	
	public final double getNetAsset() {
		return this.netAsset;
	}
	
	public final double getNetAssetOfBtc() {
		return this.netAssetOfBtc;
	}
	
	public final boolean isRepayEnabled() {
		return this.repayEnabled;
	}
	
	public final double getTotalAsset() {
		return this.totalAsset;
	}
}