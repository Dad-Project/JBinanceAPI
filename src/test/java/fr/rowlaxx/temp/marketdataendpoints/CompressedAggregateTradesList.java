package fr.rowlaxx.temp.marketdataendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CompressedAggregateTradesList extends JSavONObject {
	private static final long serialVersionUID = 4638921256859445881L;
	
	//Variables
	private int a;
	private int f;
	private int l;
	private boolean M;
	private double p;
	private double q;
	private long T;
	
	//Constructeurs
	public CompressedAggregateTradesList(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getA() {
		return this.a;
	}
	
	public final int getF() {
		return this.f;
	}
	
	public final int getL() {
		return this.l;
	}
	
	public final boolean isM() {
		return this.M;
	}
	
	public final double getP() {
		return this.p;
	}
	
	public final double getQ() {
		return this.q;
	}
	
	public final long getT() {
		return this.T;
	}
}