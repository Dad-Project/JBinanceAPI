package fr.rowlaxx.binanceapi.core.margin;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class MarginAsset extends JsavonObject {
	private static final long serialVersionUID = -8493114889588569945L;
	
	//Variables
	private String assetFullName;
	private String assetName;
	private boolean isBorrowable;
	private boolean isMortgageable;
	private double userMinBorrow;
	private double userMinRepay;
	
	//Constructeurs
	public MarginAsset(JSONObject json) {
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