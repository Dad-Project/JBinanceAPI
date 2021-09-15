package fr.rowlaxx.temp.bswapendpoints.getliquidityinformationofapool.share;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Asset extends JSavONObject {
	private static final long serialVersionUID = 1267558339259056957L;
	
	//Variables
	private double BUSD;
	private double USDT;
	
	//Constructeurs
	public Asset(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getBUSD() {
		return this.BUSD;
	}
	
	public final double getUSDT() {
		return this.USDT;
	}
}