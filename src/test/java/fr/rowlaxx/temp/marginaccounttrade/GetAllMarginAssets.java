package fr.rowlaxx.temp.marginaccounttrade;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class GetAllMarginAssets extends JSavONObject {
	private static final long serialVersionUID = 1636244035048821730L;
	
	//Variables
	private String assetFullName;
	private String assetName;
	private boolean isBorrowable;
	private boolean isMortgageable;
	private double userMinBorrow;
	private double userMinRepay;
	
	//Constructeurs
	public GetAllMarginAssets(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAssetFullName() {
		return this.assetFullName;
	}
	
	public final String getAssetName() {
		return this.assetName;
	}
	
	public final boolean isBorrowable() {
		return this.isBorrowable;
	}
	
	public final boolean isMortgageable() {
		return this.isMortgageable;
	}
	
	public final double getUserMinBorrow() {
		return this.userMinBorrow;
	}
	
	public final double getUserMinRepay() {
		return this.userMinRepay;
	}
}