package fr.rowlaxx.binanceapi.core.wallet.spot;

import java.util.Map;

import org.json.JSONObject;

import fr.rowlaxx.binanceapi.core.wallet.Balance;
import fr.rowlaxx.binanceapi.core.wallet.DailyAccountSnapshot;
import fr.rowlaxx.jsavon.annotations.JOValue;
import fr.rowlaxx.jsavon.annotations.MapKey;

public class SpotDailyAccountSnapshot extends DailyAccountSnapshot {
	private static final long serialVersionUID = 1634716526563706889L;

	//Variables
	@JOValue(path = "data") 
	private double totalAssetOfBtc;
	
	@JOValue(path = "data") 
	@MapKey(fieldName = "asset")
	private Map<String, Balance> balances;
	
	//Constructeurs
	public SpotDailyAccountSnapshot(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getTotalAssetOfBtc() {
		return totalAssetOfBtc;
	}
	
	public final Map<String, Balance> getBalances() {
		return this.balances;
	}
	
	public final Balance getBalance(String asset) {
		return this.balances.get(asset);
	}
}
