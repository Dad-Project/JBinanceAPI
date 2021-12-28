package fr.rowlaxx.binanceapi.core.general.mining;

import org.json.JSONObject;

import fr.rowlaxx.jsavon.JsavonObject;

public class CoinName extends JsavonObject {
	private static final long serialVersionUID = -7612386787136311987L;
	
	//Variables
	private int algoId;
	private String algoName;
	private int coinId;
	private String coinName;
	private int poolIndex;
	
	//Constructeurs
	public CoinName(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getAlgoId() {
		return this.algoId;
	}
	
	public final String getAlgoName() {
		return this.algoName;
	}
	
	public final int getCoinId() {
		return this.coinId;
	}
	
	public final String getCoinName() {
		return this.coinName;
	}
	
	public final int getPoolIndex() {
		return this.poolIndex;
	}
}