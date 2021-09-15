package fr.rowlaxx.temp.marginaccounttrade.querycrossmarginaccountdetails;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class UserAssets extends JSavONObject {
	private static final long serialVersionUID = 6389578661055485102L;
	
	//Variables
	private String asset;
	private double borrowed;
	private double free;
	private double interest;
	private double locked;
	private double netAsset;
	
	//Constructeurs
	public UserAssets(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAsset() {
		return this.asset;
	}
	
	public final double getBorrowed() {
		return this.borrowed;
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
}