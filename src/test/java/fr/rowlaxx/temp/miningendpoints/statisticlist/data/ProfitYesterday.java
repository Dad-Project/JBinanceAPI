package fr.rowlaxx.temp.miningendpoints.statisticlist.data;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class ProfitYesterday extends JSavONObject {
	private static final long serialVersionUID = 4948467779085981806L;
	
	//Variables
	private double BCH;
	private double BSV;
	private double BTC;
	
	//Constructeurs
	public ProfitYesterday(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final double getBCH() {
		return this.BCH;
	}
	
	public final double getBSV() {
		return this.BSV;
	}
	
	public final double getBTC() {
		return this.BTC;
	}
}