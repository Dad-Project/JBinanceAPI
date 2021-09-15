package fr.rowlaxx.temp.walletendpoints.accountapitradingstatus.data.indicators;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class ETHUSDT extends JSavONObject {
	private static final long serialVersionUID = -4897990561047803237L;
	
	//Variables
	private int c;
	private String i;
	private double t;
	private double v;
	
	//Constructeurs
	public ETHUSDT(JSONObject json) {
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