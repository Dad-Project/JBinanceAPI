package fr.rowlaxx.binanceapi.core.mining;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class ProfitTransferDetail extends JsavonObject {
	private static final long serialVersionUID = 5541534486592989501L;
	
	//Variables
	private String algoName;
	private double amount;
	private String coinName;
	private int day;
	private long hashRate;
	private String poolUsername;
	private String toPoolUsername;
	
	//Constructeurs
	public ProfitTransferDetail(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final String getAlgoName() {
		return this.algoName;
	}
	
	public final double getAmount() {
		return this.amount;
	}
	
	public final String getCoinName() {
		return this.coinName;
	}
	
	public final int getDay() {
		return this.day;
	}
	
	public final long getHashRate() {
		return this.hashRate;
	}
	
	public final String getPoolUsername() {
		return this.poolUsername;
	}
	
	public final String getToPoolUsername() {
		return this.toPoolUsername;
	}
}