package fr.rowlaxx.binanceapi.core.subaccount;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class ManagedAsset extends JsavonObject {
	private static final long serialVersionUID = 5561401427903070214L;
	
	//Variables
	private int availableBalance;
	private int btcValue;
	private String coin;
	private int inOrder;
	private String name;
	private int totalBalance;
	
	//Constructeurs
	public ManagedAsset(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getAvailableBalance() {
		return this.availableBalance;
	}
	
	public final int getBtcValue() {
		return this.btcValue;
	}
	
	public final String getCoin() {
		return this.coin;
	}
	
	public final int getInOrder() {
		return this.inOrder;
	}
	
	public final String getName() {
		return this.name;
	}
	
	public final int getTotalBalance() {
		return this.totalBalance;
	}
}