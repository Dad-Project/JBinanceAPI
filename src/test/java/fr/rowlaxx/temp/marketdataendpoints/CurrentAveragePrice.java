package fr.rowlaxx.temp.marketdataendpoints;

import fr.rowlaxx.jsavon.JSavONObject;

import org.json.JSONObject;

public class CurrentAveragePrice extends JSavONObject {
	private static final long serialVersionUID = -1092219404614702932L;
	
	//Variables
	private int mins;
	private double price;
	
	//Constructeurs
	public CurrentAveragePrice(JSONObject json) {
		super(json);
	}
	
	//Getters
	public final int getMins() {
		return this.mins;
	}
	
	public final double getPrice() {
		return this.price;
	}
}