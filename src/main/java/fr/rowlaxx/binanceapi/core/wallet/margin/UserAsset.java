package fr.rowlaxx.binanceapi.core.wallet.margin;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.wallet.Balance;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class UserAsset extends Balance {
	private static final long serialVersionUID = -7794836890023245527L;

	//Variables
	@JOValue private double borrowed, interest, netAsset;
	
	//Constructeurs
	public UserAsset(JSONObject json) {
		super(json);
	}
	
	//Getters
	public double getInterest() {
		return interest;
	}
	
	public double getNetAsset() {
		return netAsset;
	}
	
	public double getBorrowed() {
		return borrowed;
	}
}
