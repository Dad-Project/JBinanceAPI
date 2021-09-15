package fr.rowlaxx.temp.walletendpoints.accountapitradingstatus.data.indicators;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class BTCUSDT extends JSavONObject {
	private static final long serialVersionUID = -855231720584463981L;
	
	//Variables
	private int c;
	private String i;
	private double t;
	private double v;
	
	//Constructeurs
	public BTCUSDT(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getC() {
		return this.c;
	}
	
	public final String getI() {
		return this.i;
	}
	
	public final double getT() {
		return this.t;
	}
	
	public final double getV() {
		return this.v;
	}
}