package fr.rowlaxx.temp.bswapendpoints.getliquidityinformationofapool;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class Liquidity extends JSavONObject {
	private static final long serialVersionUID = 3009923102469167105L;
	
	//Variables
	private double BUSD;
	private double USDT;
	
	//Constructeurs
	public Liquidity(JSONObject json) {
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