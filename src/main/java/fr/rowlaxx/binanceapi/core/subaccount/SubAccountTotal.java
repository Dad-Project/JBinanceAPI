package fr.rowlaxx.binanceapi.core.subaccount;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class SubAccountTotal extends JsavonObject {
	private static final long serialVersionUID = -8919630971608785330L;
	
	//Variables
	private String email;
	private double totalAssetOfBtc;
	private double totalLiabilityOfBtc;
	private double totalNetAssetOfBtc;
	
	//Constructeurs
	public SubAccountTotal(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getEmail() {
		return this.email;
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