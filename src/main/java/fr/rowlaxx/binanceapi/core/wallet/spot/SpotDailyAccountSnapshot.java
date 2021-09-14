package fr.rowlaxx.binanceapi.core.wallet.spot;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.wallet.Balance;
import fr.rowlaxx.binanceapi.core.wallet.DailyAccountSnapshot;
import fr.rowlaxx.jsavon.annotations.MapKey;
import fr.rowlaxx.jsavon.annotations.object.JOValue;

public class SpotDailyAccountSnapshot extends DailyAccountSnapshot {
	private static final long serialVersionUID = 1634716526563706889L;

	//Variables
	@JOValue(path = "data") private double totalAssetOfBtc;
	@JOValue(path = "data") 
	@MapKey(fieldName = "asset")
	private Map<String, Balance> balances;
	
	//Constructeurs
	public SpotDailyAccountSnapshot(JSONObject json) {
		super(json);
	}
	
	//Getters
	public double getTotalAssetOfBtc() {
		return totalAssetOfBtc;
	}
	
	public Map<String, Balance> getBalances() {
		return balances;
	}
	
	public Balance getBalance(String asset) {
		return balances.get(asset);
	}
}
