package fr.rowlaxx.binanceapi.core.wallet;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.Asset;
import fr.rowlaxx.convertutils.MapKey;
import fr.rowlaxx.jsavon.annotations.JOValue;

public class SpotAccountSnapshot extends AccountSnapshot {
	private static final long serialVersionUID = 1634716526563706889L;

	//Variables
	@JOValue(path = "data") 
	private double totalAssetOfBtc;
	
	@JOValue(path = "data") 
	@MapKey(fieldName = "asset")
	private Map<String, Asset> balances;
	
	//Constructeurs
	public SpotAccountSnapshot(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getTotalAssetOfBtc() {
		return totalAssetOfBtc;
	}
	
	public final Map<String, Asset> getBalances() {
		return this.balances;
	}
	
	public final Asset getBalance(String asset) {
		return this.balances.get(asset);
	}
}
