package fr.rowlaxx.temp.walletendpoints.dailyaccountsnapshot.snapshotvos;

import fr.rowlaxx.jsavon.JSavONObject;
import fr.rowlaxx.temp.walletendpoints.dailyaccountsnapshot.snapshotvos.data.Balances;

import java.util.List;

import org.json.JSONObject;

public class Data extends JSavONObject {
	private static final long serialVersionUID = -5638219896671560999L;
	
	//Variables
	private List<Balances> balances;
	private double totalAssetOfBtc;
	
	//Constructeurs
	public Data(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final List<Balances> getBalances() {
		return this.balances;
	}
	
	public final double getTotalAssetOfBtc() {
		return this.totalAssetOfBtc;
	}
}